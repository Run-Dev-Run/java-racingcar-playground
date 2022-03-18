public class MoveByRandomNumberStrategy implements MoveStrategy{

    private final NumberFactory factory;

    public MoveByRandomNumberStrategy(NumberFactory factory) {
        this.factory = factory;
    }

    @Override
    public void move(Position position) {
        AbstractNumber randomNumber = factory.produce();
        if (randomNumber.isMoreThan(4)) {
            position.moveOneStep();
        }
    }

}
