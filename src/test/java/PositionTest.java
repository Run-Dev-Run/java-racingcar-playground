import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position 단위 테스트")
class PositionTest {

    public final int INVALID_STEP_NUMBER = -1;
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    @DisplayName("Position은 step에 음수가 입력된다면, 예외를 던집니다.")
    void test_construct_Position_validate_invalid_step_number() {
        assertThatThrownBy(() -> new Position(INVALID_STEP_NUMBER))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("moveOneStep()는 Position의 step을 1 증가 시킵니다.")
    void test_moveOneStep() {
        position.moveOneStep();

        assertThat(position).isEqualTo(new Position(1));
    }
}
