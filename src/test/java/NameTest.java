import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.platform.commons.function.Try.success;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Name 단위테스트")
class NameTest {

    private final String VALID_NAME = "12345";
    private final String INVALID_NAME = "123456";
    private final String NAME_LENGTH_OVER_MESSAGE = "자동차 이름은 5자를 초과할 수 없다.";

    @Test
    @DisplayName("이름의 길이는 5자를 초과 할 수 없다.")
    void test_name_validate_over_max_length() {
        assertThatThrownBy(() -> new Name(INVALID_NAME))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NAME_LENGTH_OVER_MESSAGE);
    }

    @Test
    @DisplayName("길이 5이하의 문자열을 통해 Name 객체를 생성한다.")
    void test_name_validate_valid() {
        success(new Name(VALID_NAME));
    }

}
