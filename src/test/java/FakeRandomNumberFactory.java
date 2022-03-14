import java.util.ArrayList;
import java.util.List;

public class FakeRandomNumberFactory implements AbleToProduceRandomNumber {

    public final int MOVE_NUMBER = 3;
    public final int STOP_NUMBER = 4;
    public final int MOVE_TARGET_CAR_COUNT = 2;

    private List<Integer> numberPool;
    private int currentIndex;

    public FakeRandomNumberFactory(int carsLength) {
        this.currentIndex = 0;
        this.numberPool = new ArrayList<>();

        settingFakeData(carsLength);
    }

    private void settingFakeData(int carsLength) {
        for (int i = 0; i < carsLength - MOVE_TARGET_CAR_COUNT; i++) {
            this.numberPool.add(MOVE_NUMBER);
        }
        for (int i = carsLength - MOVE_TARGET_CAR_COUNT; i < carsLength; i++) {
            this.numberPool.add(STOP_NUMBER);
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
