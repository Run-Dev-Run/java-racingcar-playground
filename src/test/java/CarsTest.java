import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Cars 단위 테스트")
class CarsTest {

    @ParameterizedTest
    @DisplayName("Cars는 Null이나 빈 리스트가 인자로 주어진다면 예외를 덥집니다.")
    @MethodSource("provideInvalidArgumentsForConstructValidation")
    void test_construct_validate_invalid_arguments(List<Car> input) {
        assertThatThrownBy(() -> new Cars(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidArgumentsForConstructValidation() {
        return Stream.of(
            Arguments.of((Object) null),
            Arguments.of(new ArrayList<Car>())
        );
    }

    @Test
    @DisplayName("move()는 랜덤 숫자에 따라 Car를 전진시킵니다.")
    void test_move() {
        List<Car> inputCarList = new ArrayList<>(
            Arrays.asList(new Car("a"),
                new Car("b"),
                new Car("c"),
                new Car("d"),
                new Car("e")
            )
        );
        List<Car> resultCarList = new ArrayList<>(
            Arrays.asList(new Car("a"),
                new Car("b"),
                new Car("c"),
                new Car("d", 1),
                new Car("e", 1)
            )
        );
        Cars cars = new Cars(inputCarList);
        RandomNumberFactory factory = new FakeBasicRandomNumberFactory(inputCarList.size());

        cars.move(factory);

        assertThat(cars).isEqualTo(new Cars(resultCarList));
    }

}
