import java.util.Random;

public class RangeableRandomNumberFactory extends NumberFactory {

    public final int MAX_RANDOM_NUMBER = 9;

    private final Random random;

    public RangeableRandomNumberFactory() {
        random = new Random();
    }

    @Override
    public AbstractNumber produce() {
        return new RangeableRandomNumber(random.nextInt(MAX_RANDOM_NUMBER));
    }

}
