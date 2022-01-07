package exception;

import java.util.List;

public class UnknownException extends Exception {
    private String className;
    private String errorMessage;
    private List<String> errorTrace;

    public UnknownException(String className, String errorMessage, Exception ex) {
        this.className = className != null ? className : this.getClass().getSimpleName();
        this.errorMessage = errorMessage;
    }

    public UnknownException(String errorMessage, Exception ex) {
        this(null, errorMessage, ex);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrorTrace() {
        return errorTrace;
    }
}
