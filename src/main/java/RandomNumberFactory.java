public class RandomNumberFactory implements AbleToProduceRandomNumber{

    @Override
    public RandomNumber produce() {
        return new RandomNumber();
    }

}
