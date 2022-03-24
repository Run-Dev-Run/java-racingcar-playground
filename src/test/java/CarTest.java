import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 단위 테스트")
public class CarTest {

    private static final String DEFAULT_CAR_NAME = "name";

    @Test
    void move_메서드는_주어진_전략에_따라_자동차를_움직입니다() {

        Car car = new Car(DEFAULT_CAR_NAME, Position::moveOneStep);
        MoveStrategy fakeAbsoluteMoveStrategy = ( Position::moveOneStep );

        Car movedCar = new Car(DEFAULT_CAR_NAME, 1, fakeAbsoluteMoveStrategy);
        car.move();

        assertThat(car).isEqualTo(movedCar);
    }

}
