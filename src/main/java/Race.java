public class Race {

    private final TryCount tryCount;

    private final Cars cars;

    public Race(int tryCount, Cars cars) {
        this.tryCount = new TryCount(tryCount);
        this.cars = cars;
    }

    public void start() {
        int currentTryCount = 0;
        while (tryCount.isOverThan(currentTryCount)){
            this.cars.move();
            currentTryCount++;
        }
    }

}
