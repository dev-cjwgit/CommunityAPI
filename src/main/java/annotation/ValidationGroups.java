package annotation;

import javax.validation.groups.Default;

public class ValidationGroups {
    private ValidationGroups() {
    }

    public interface signup extends Default {};

    public interface login extends Default {};

    public interface withdraw extends Default{};

    public interface searchBoard extends Default{};
}
