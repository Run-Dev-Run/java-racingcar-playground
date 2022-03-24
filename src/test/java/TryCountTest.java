import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TryCount 단위 테스트")
class TryCountTest {

    @Test
    void TryCount는_0_이하를_인자로_전달할_경우_예외를_던집니다() {
        assertThatThrownBy(() -> new TryCount(TryCount.MIN_TRY_COUNT))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TryCount는_1_이상을_인자로_전달할_경우_인스턴스를_생성합니다() {
        TryCount tryCount = new TryCount(TryCount.MIN_TRY_COUNT + 1);

        assertThat(tryCount).isNotNull();
    }

    @Test
    void getNextTryCount_메서드는_전체_TryCount_수에서_한번_사용한_TryCount를_반환합니다() {
        int INPUT_TRT_COUNT = 5;
        TryCount tryCount = new TryCount(INPUT_TRT_COUNT);

        assertThat(tryCount.getNextTryCount()).isEqualTo(new TryCount(INPUT_TRT_COUNT, TryCount.DEFAULT_CURRENT_TRY_COUNT + 1));
    }

    @Test
    void complete_메서드는_TryCount_완료_여부를_반환합니다() {
        int INPUT_TRT_COUNT = 1;
        TryCount tryCount = new TryCount(INPUT_TRT_COUNT, TryCount.DEFAULT_CURRENT_TRY_COUNT);
        assertThat(tryCount.isComplete()).isFalse();

        TryCount nextTryCount = tryCount.getNextTryCount();
        assertThat(nextTryCount.isComplete()).isTrue();
    }

}
