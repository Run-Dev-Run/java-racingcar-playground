import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Car 단위 테스트")
public class CarTest {

    private static final RandomNumber RANDOM_NUMBER_MORE_THAN_FOUR_OBJECT = new RandomNumber(4);
    public static final RandomNumber RANDOM_NUMBER_LESS_THAN_FOUR_OBJECT = new RandomNumber(3);
    public static final Name DEFAULT_CAR_NAME_OBJECT = new Name("name");
    public static final Position DEFAULT_POSITION_OBJECT = new Position();
    
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(DEFAULT_CAR_NAME_OBJECT, DEFAULT_POSITION_OBJECT);
    }

    @ParameterizedTest
    @DisplayName("Car의 인자로 Null이 주어질 경우, 예외를 던집니다.")
    @MethodSource("provideCarArgumentsForValidation")
    void test_construct_Car_validate_invalid_arguments(Name nullableCarName, Position nullablePosition) {
        assertThatThrownBy(() -> new Car(nullableCarName, nullablePosition))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideCarArgumentsForValidation() {
        return Stream.of(
            Arguments.of(DEFAULT_CAR_NAME_OBJECT, null),
            Arguments.of(null, DEFAULT_POSITION_OBJECT),
            Arguments.of(null, null)
        );
    }

    @Test
    @DisplayName("Car의 인자로 Null이 아닌 객체가 주어질 경우, Car 객체를 생성합니다.")
    void test_construct_Car_validate_valid_arguments() {
        Car newCar = new Car(DEFAULT_CAR_NAME_OBJECT, DEFAULT_POSITION_OBJECT);

        assertThat(newCar).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("move()는 4이상의 수가 입력될 경우 1칸 전진하고 아닐 경우 그대로 정지합니다.")
    @MethodSource("provideRandomNumberForMoving")
    void test_move(RandomNumber randomNumber, Car expected) {
        car.move(randomNumber);

        assertThat(car).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRandomNumberForMoving() {
        Position stoppedPosition = new Position();
        Position oneStepMovedPosition = new Position(1);

        Car stoppedCar = new Car(DEFAULT_CAR_NAME_OBJECT, stoppedPosition);
        Car oneStepMoveCar = new Car(DEFAULT_CAR_NAME_OBJECT, oneStepMovedPosition);

        return Stream.of(
            Arguments.of(RANDOM_NUMBER_LESS_THAN_FOUR_OBJECT, stoppedCar),
            Arguments.of(RANDOM_NUMBER_MORE_THAN_FOUR_OBJECT, oneStepMoveCar)
        );
    }

}
