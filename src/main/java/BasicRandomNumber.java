public class BasicRandomNumber extends AbstractRandomNumber{

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public BasicRandomNumber(int number) {
        super(number, MAX_RANDOM_NUMBER, MIN_RANDOM_NUMBER);
    }

}
