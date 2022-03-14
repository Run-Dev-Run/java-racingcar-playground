import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.platform.commons.function.Try.success;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Try 단위 테스트")
public class TryTest {

    public final int ONE = 1;
    public final int ZERO = 0;

    @Test
    @DisplayName("Try는 횟수(count)에 0 이하를 입력 할 경우, 예외를 던집니다.")
    void test_try_validate_less_than_zero() {
        assertThatThrownBy(() -> new Try(ZERO))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Try.TRY_COUNT_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("Try는 횟수(count)에 1 이상을 입력할 경우, 성공합니다.")
    void test_try_validate_more_than_zero() {
        success(new Try(ONE));
    }

}
