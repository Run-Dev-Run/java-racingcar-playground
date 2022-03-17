public abstract class AbstractNumber {

    private final int number;

    public AbstractNumber(int number) {
        this.number = number;
    }

    public boolean isMoreThan(int comparisonNumber) {
        return comparisonNumber <= number;
    }

    public boolean isLessThan(int comparisonNumber) {
        return comparisonNumber >= number;
    }

}
