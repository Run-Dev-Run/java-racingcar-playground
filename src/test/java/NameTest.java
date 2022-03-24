import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.platform.commons.function.Try.success;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Name 단위테스트")
class NameTest {

    private final String VALID_NAME = "12345";
    private final String INVALID_NAME = "123456";

    private final int MAX_NAME_LENGTH = Name.MAX_NAME_LENGTH;

    @Test
    void 이름의_길이는_MAX_NAME_LENGTH_자를_초과_할_수_없다() {
        assertThatThrownBy(() -> new Name(INVALID_NAME))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_MAX_NAME_LENGTH_이하의_문자열을_통해_Name_객체를_생성한다() {
        success(new Name(VALID_NAME));
    }

}
