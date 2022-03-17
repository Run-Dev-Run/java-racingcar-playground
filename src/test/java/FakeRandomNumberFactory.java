import java.util.ArrayList;
import java.util.List;

public class FakeRandomNumberFactory extends NumberFactory {

    private final int MOVE_NUMBER = 4;
    private final int STOP_NUMBER = 3;
    private final int MOVE_TARGET_CAR_COUNT = 2;

    private final List<Integer> numberPool;
    private int currentIndex;

    public FakeRandomNumberFactory(int carsLength) {
        this.currentIndex = 0;
        this.numberPool = new ArrayList<>();

        settingFakeData(carsLength);
    }

    private void settingFakeData(int carsLength) {
        for (int i = 0; i < carsLength - MOVE_TARGET_CAR_COUNT; i++) {
            this.numberPool.add(STOP_NUMBER);
        }
        for (int i = carsLength - MOVE_TARGET_CAR_COUNT; i < carsLength; i++) {
            this.numberPool.add(MOVE_NUMBER);
        }
    }

    @Override
    public RandomNumber produce() {
        int numberPoolIndex = currentIndex % numberPool.size();
        plusCurrentIndex();
        return new RandomNumber(numberPool.get(numberPoolIndex));
    }

    private void plusCurrentIndex() {
        currentIndex++;
    }

}
