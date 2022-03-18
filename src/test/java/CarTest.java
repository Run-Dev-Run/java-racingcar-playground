import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Car 단위 테스트")
public class CarTest {

    private static final String DEFAULT_CAR_NAME = "name";

    @ParameterizedTest
    @DisplayName("move()는 4이상의 수가 입력될 경우 1칸 전진하고 아닐 경우 그대로 정지합니다.")
    @MethodSource("provideRandomNumberForMoving")
    void test_move(NumberFactory fakeRandomNumberFactory, Car expected) {

        Car car = new Car(DEFAULT_CAR_NAME, new MoveByRandomNumberStrategy(fakeRandomNumberFactory));
        car.move();

        assertThat(car).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRandomNumberForMoving() {
        int stoppedPositionNumber = 0;
        int oneStepMovedPositionNumber = 1;
        FakeRandomNumberFactory TreeNumberFactory = new FakeRandomNumberFactory(3);
        FakeRandomNumberFactory FourNumberFactory = new FakeRandomNumberFactory(4);
        Car stoppedCar = new Car(DEFAULT_CAR_NAME, stoppedPositionNumber, new MoveByRandomNumberStrategy(TreeNumberFactory));
        Car oneStepMoveCar = new Car(DEFAULT_CAR_NAME, oneStepMovedPositionNumber, new MoveByRandomNumberStrategy(FourNumberFactory));

        return Stream.of(
            Arguments.of(TreeNumberFactory, stoppedCar),
            Arguments.of(FourNumberFactory, oneStepMoveCar)
        );
    }

}
