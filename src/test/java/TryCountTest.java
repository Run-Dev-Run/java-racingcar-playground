import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TryCount 단위 테스트")
class TryCountTest {

    public static final int MORE_THAN_ZERO_NUMBER = 0;
    public static final int LESS_THAN_ZERO_NUMBER = 1;

    @Test
    @DisplayName("TryCount는 0 이하를 인자로 전달할 경우 예외를 던집니다.")
    void test_construct_TryCount_validate_less_than_zero() {
        assertThatThrownBy(() -> new TryCount(MORE_THAN_ZERO_NUMBER))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("TryCount는 1 이상을 인자로 전달할 경우 인스턴스를 생성합니다.")
    void test_construct_TryCount_validate_more_than_zero() {
        TryCount tryCount = new TryCount(LESS_THAN_ZERO_NUMBER);

        assertThat(tryCount).isNotNull();
    }

}
