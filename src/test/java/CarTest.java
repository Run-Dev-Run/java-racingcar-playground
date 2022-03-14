import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Car 단위 테스트")
public class CarTest {

    private static final RandomNumber RANDOM_NUMBER_MORE_THAN_FOUR_OBJECT = new RandomNumber(4);
    public static final RandomNumber RANDOM_NUMBER_LESS_THAN_FOUR_OBJECT = new RandomNumber(3);
    public static final String DEFAULT_CAR_NAME = "name";

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(DEFAULT_CAR_NAME);
    }

    @ParameterizedTest
    @DisplayName("move()는 4이상의 수가 입력될 경우 1칸 전진하고 아닐 경우 그대로 정지합니다.")
    @MethodSource("provideRandomNumberForMoving")
    void test_move(RandomNumber randomNumber, Car expected) {
        car.move(randomNumber);

        assertThat(car).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRandomNumberForMoving() {
        int stoppedPositionNumber = 0;
        int oneStepMovedPositionNumber = 1;

        Car stoppedCar = new Car(DEFAULT_CAR_NAME, stoppedPositionNumber);
        Car oneStepMoveCar = new Car(DEFAULT_CAR_NAME, oneStepMovedPositionNumber);

        return Stream.of(
            Arguments.of(RANDOM_NUMBER_LESS_THAN_FOUR_OBJECT, stoppedCar),
            Arguments.of(RANDOM_NUMBER_MORE_THAN_FOUR_OBJECT, oneStepMoveCar)
        );
    }

}
