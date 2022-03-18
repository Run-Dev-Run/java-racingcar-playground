import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("MoveByRandomNumberStrategy 단위테스트")
class MoveByRandomNumberStrategyTest {

    @ParameterizedTest
    @MethodSource("provideFakeRandomNumberForMoving")
    void move는_4이상의_수를_입력하면_1칸_움직인_Position을_반환합니다(int fakeNumber, Position expect) {
        Position position = new Position();
        MoveStrategy strategy = new MoveByRandomNumberStrategy(new FakeRandomAbstractNumberFactory(fakeNumber));
        Position result = strategy.move(position);

        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideFakeRandomNumberForMoving() {
        int step = 0;
        Position position = new Position(step);
        Position movedPosition = new Position(step + 1);

        int fakeNumberForStop = 3;
        int fakeNumberForMove = 4;

        return Stream.of(
            Arguments.of(fakeNumberForStop, position),
            Arguments.of(fakeNumberForMove, movedPosition)
        );
    }

}
