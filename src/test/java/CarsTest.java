import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Cars 단위 테스트")
class CarsTest {

    @ParameterizedTest
    @MethodSource("provideInvalidArgumentsForConstructValidation")
    void Cars는_Null이나_빈_리스트가_인자로_주어진다면_예외를_덥집니다(List<Car> input) {
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
        List<String> inputCarNames = Arrays.asList("a", "b", "c", "d", "e");
        int fakeNumber = 5;
        MoveStrategy strategy = new MoveByRandomNumberStrategy(new FakeRandomNumberFactory(fakeNumber));
        List<Car> resultCarList = new ArrayList<>(
            inputCarNames.stream()
            .map(s -> new Car(s, 1, strategy))
            .collect(Collectors.toList())
        );
        Cars cars = new Cars(
            inputCarNames.stream()
                .map(s -> new Car(s, strategy))
                .collect(Collectors.toList())
        );

        cars.move();

        assertThat(cars).isEqualTo(new Cars(resultCarList));
    }

}
