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
    void 이름의_길이는_5자를_초과_할_수_없다() {
        assertThatThrownBy(() -> new Name(INVALID_NAME))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NAME_LENGTH_OVER_MESSAGE);
    }

    @Test
    void 길이_5이하의_문자열을_통해_Name_객체를_생성한다() {
        success(new Name(VALID_NAME));
    }

}
