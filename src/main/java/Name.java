import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_OVER_MESSAGE = "자동차 이름은 5자를 초과할 수 없다.";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (Objects.isNull(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_MESSAGE);
        }
    }

}
