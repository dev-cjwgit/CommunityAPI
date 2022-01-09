package util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.messaging.saaj.util.Base64;
import enums.ErrorMessage;
import exception.BaseException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repository.AccountMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class Jwt {
    @Value("${token.key}")
    private String SECRET_KEY;  // TODO: Key는 하드코딩 하지말고 외부에서 가져오는것을 권장

    @Autowired
    private AccountMapper accountMapper;

    //토큰 생성
    public String createToken(Long uid, String salt) {
        //Header 부분 설정
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //payload 부분 설정
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("uid", uid);

        long expiredTime = 1000L * 60 * 60 * 5; // TODO: 토큰 유효 시간 (5 시간)

        Date ext = new Date(); // 토큰 만료 시간
        ext.setTime(ext.getTime() + expiredTime);

        // 토큰 Builder
        String jwt = Jwts.builder()
                .setHeader(headers) // Headers 설정
                .setClaims(payloads) // Claims 설정
                .setSubject("auth-user") // 토큰 용도
                .setExpiration(ext) // 토큰 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, (SECRET_KEY + salt).getBytes()) // HS256과 Key로 Sign
                .compact(); // 토큰 생성

        return jwt;
    }

    //토큰 검증
    public Map<String, Object> verifyJWT(String jwt) throws Exception {
        Map<String, Object> claimMap = null;
        long uid = getUid(jwt);
        String salt = accountMapper.getSaltToUid(uid);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey((SECRET_KEY + salt).getBytes("UTF-8")) // Set Key
                    .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
                    .getBody();

            claimMap = claims;

        } catch (ExpiredJwtException ex) {
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_EXPIRE);
        } catch (MalformedJwtException ex) {
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID_HEADER);
        } catch (SignatureException ex) {
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID_SIGNATURE);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return claimMap;
    }

    private Long getUid(String jwt) throws Exception {
        try {
            if (jwt.chars().filter(c -> c == '.').count() != 2)
                throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID_STRUCT);

            Map<String, Object> map;
            map = new ObjectMapper().readValue(Base64.base64Decode(jwt.split("\\.")[1]), Map.class);
            if (map.get("uid") == null)
                throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID_PAYLOADS);

            return Long.parseLong(map.get("uid").toString());
        } catch (JsonParseException ex) {
            throw new BaseException(ErrorMessage.ACCESS_TOKEN_INVALID_PAYLOADS);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}