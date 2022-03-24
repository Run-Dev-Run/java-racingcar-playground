import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position 단위 테스트")
class PositionTest {

    private final int INVALID_STEP_NUMBER = -1;
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    void Position은_step에_음수가_입력된다면_예외를_던집니다() {
        assertThatThrownBy(() -> new Position(INVALID_STEP_NUMBER))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveOneStep은_Position의_step을_1_증가_시킨_후_반환합니다() {
        Position result = this.position.moveOneStep();
        Position expected = new Position(1);

        assertThat(result).isEqualTo(expected);
    }

}
