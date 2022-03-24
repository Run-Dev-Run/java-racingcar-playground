import java.util.Random;

public class RangeableRandomNumberFactory extends AbstractRandomNumberFactory {

    public static final int DEFAULT_MAX_RANDOM_NUMBER = 9;
    public static final int DEFAULT_MIN_RANDOM_NUMBER = 0;

    private final Random random;
    private final int max;
    private final int min;

    public RangeableRandomNumberFactory(int max, int min) {
        random = new Random();
        this.max = max;
        this.min = min;
    }

    public RangeableRandomNumberFactory() {
        random = new Random();
        this.max = DEFAULT_MAX_RANDOM_NUMBER;
        this.min = DEFAULT_MIN_RANDOM_NUMBER;
    }

    @Override
    public AbstractRandomNumber produce() {
        return new RangeableRandomNumber(random.nextInt(max+min) + min, max, min);
    }

}
