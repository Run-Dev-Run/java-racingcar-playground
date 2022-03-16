public class Race {

    private final TryCount tryCount;

    private final Cars cars;

    private final RandomNumberFactory factory;

    public Race(int tryCount, Cars cars, RandomNumberFactory factory) {
        this.tryCount = new TryCount(tryCount);
        this.cars = cars;
        this.factory = factory;
    }

    public void start() {
        int currentTryCount = TryCount.MIN_TRY_COUNT;
        while (tryCount.isOverThan(currentTryCount)){
            this.cars.move(factory);
            currentTryCount++;
        }
    }

}
