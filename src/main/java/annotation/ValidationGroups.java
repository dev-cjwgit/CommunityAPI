package annotation;

import javax.validation.groups.Default;

public class ValidationGroups {
    private ValidationGroups() {
    }

    public interface signUp extends Default {};

    public interface login extends Default {};
}
