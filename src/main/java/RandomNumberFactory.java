import java.util.Random;

public class RandomNumberFactory extends NumberFactory {

    public final int MAX_RANDOM_NUMBER = 9;

    private final Random random;

    public RandomNumberFactory() {
        random = new Random();
    }

    @Override
    public AbstractNumber produce() {
        return new RandomNumber(random.nextInt(MAX_RANDOM_NUMBER));
    }

}
