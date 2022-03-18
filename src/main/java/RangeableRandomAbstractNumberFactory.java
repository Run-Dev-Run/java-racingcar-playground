import java.util.Random;

public class RangeableRandomAbstractNumberFactory extends AbstractNumberFactory {

    public final int MAX_RANDOM_NUMBER = 9;

    private final Random random;

    public RangeableRandomAbstractNumberFactory() {
        random = new Random();
    }

    @Override
    public AbstractNumber produce() {
        return new RangeableRandomNumber(random.nextInt(MAX_RANDOM_NUMBER));
    }

}
