import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TryCount 단위 테스트")
class TryCountTest {

    private final int MORE_THAN_ZERO_NUMBER = 0;
    private final int LESS_THAN_ZERO_NUMBER = 1;

    @Test
    void TryCount는_0_이하를_인자로_전달할_경우_예외를_던집니다() {
        assertThatThrownBy(() -> new TryCount(MORE_THAN_ZERO_NUMBER))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TryCount는_1_이상을_인자로_전달할_경우_인스턴스를_생성합니다() {
        TryCount tryCount = new TryCount(LESS_THAN_ZERO_NUMBER);

        assertThat(tryCount).isNotNull();
    }

}
