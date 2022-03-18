public class MoveByRandomNumberStrategy implements MoveStrategy{

    private final int MOVABLE_CAR_MIN_NUMBER = 4;
    private final NumberFactory factory;

    public MoveByRandomNumberStrategy(NumberFactory factory) {
        this.factory = factory;
    }

    @Override
    public Position move(Position position) {
        AbstractNumber randomNumber = factory.produce();
        if (randomNumber.isMoreThan(MOVABLE_CAR_MIN_NUMBER)) {
            return position.moveOneStep();
        }
        return position;
    }

}
