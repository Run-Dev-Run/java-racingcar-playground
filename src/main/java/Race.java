public class Race {

    private final TryCount tryCount;

    private final Cars cars;

    private final NumberFactory factory;

    public Race(int tryCount, Cars cars, NumberFactory factory) {
        this.tryCount = new TryCount(tryCount);
        this.cars = cars;
        this.factory = factory;
    }

    public void start() {
        int currentTryCount = 0;
        while (tryCount.isOverThan(currentTryCount)){
            this.cars.move(factory);
            currentTryCount++;
        }
    }

}
