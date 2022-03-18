public class Race {

    private TryCount tryCount;

    private Cars cars;

    public Race(int tryCount, Cars cars) {
        this.tryCount = new TryCount(tryCount);
        this.cars = cars;
    }

    public void start() {
        tryCount.startTryUpToTryCount(cars);
    }

}
