import java.util.Random;

public class BasicRandomNumberFactory implements RandomNumberFactory {

    public final int MAX_RANDOM_NUMBER = 9;

    private final Random random;

    public BasicRandomNumberFactory() {
        random = new Random();
    }

    @Override
    public BasicRandomNumber produce() {
        return new BasicRandomNumber(random.nextInt(MAX_RANDOM_NUMBER));
    }

}
