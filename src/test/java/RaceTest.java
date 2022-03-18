import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Race 단위 테스트")
public class RaceTest {

    private final int TRY_COUNT = 5;

    public Cars cars;
    public Race race;
    private MoveStrategy strategy;
    private List<String> inputCarNames;

    @BeforeEach
    void setUp() {
        inputCarNames = Arrays.asList("a", "b", "c", "d", "e");
        int fakeNumber = 5;
        strategy = new MoveByRandomNumberStrategy(new FakeRandomNumberFactory(fakeNumber));
        cars = new Cars(
            inputCarNames.stream()
                .map(s -> new Car(s, strategy))
                .collect(Collectors.toList())
        );
        race = new Race(TRY_COUNT, cars);
    }

    @Test
    @DisplayName("start()는 tryCount번 반복해서 자동차들을 RandomNumber에 따라 전진시킵니다.")
    void test_start() {
        List<Car> resultCarList = inputCarNames.stream()
            .map(s -> new Car(s, TRY_COUNT, strategy))
            .collect(Collectors.toList());

        race.start();

        assertThat(cars).isEqualTo(new Cars(resultCarList));
    }

}
