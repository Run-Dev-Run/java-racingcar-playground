import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Race 단위 테스트")
public class RaceTest {

    private final int TRY_COUNT = 5;

    private NumberFactory factory;
    public Cars cars;
    public Race race;

    @BeforeEach
    void setUp() {
        List<Car> inputCarList = new ArrayList<>(
            Arrays.asList(new Car("a"),
                new Car("b"),
                new Car("c"),
                new Car("d"),
                new Car("e")
            )
        );
        factory = new FakeRandomNumberFactory(inputCarList.size());
        cars = new Cars(inputCarList);
        race = new Race(TRY_COUNT, cars, factory);
    }

    @Test
    @DisplayName("start()는 tryCount번 반복해서 자동차들을 RandomNumber에 따라 전진시킵니다.")
    void test_start() {
        List<Car> resultCarList = new ArrayList<>(
            Arrays.asList(new Car("a"),
                new Car("b"),
                new Car("c"),
                new Car("d", TRY_COUNT),
                new Car("e", TRY_COUNT)
            )
        );

        race.start();

        assertThat(cars).isEqualTo(new Cars(resultCarList));
    }

}
