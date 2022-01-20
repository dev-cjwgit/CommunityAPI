package domain.dto;

public class SlackDTO {
    private String username;
    private String text;
    private String iconEmoji;

    public SlackDTO(String username, String text, String iconEmoji) {
        this.username = username;
        this.text = text;
        this.iconEmoji = iconEmoji;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon_emoji() {
        return iconEmoji;
    }

    public void setIcon_emoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }
}
