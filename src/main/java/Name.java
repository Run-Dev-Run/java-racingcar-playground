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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
