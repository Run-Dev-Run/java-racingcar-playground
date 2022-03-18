public class FakeRandomAbstractNumberFactory extends AbstractNumberFactory {

    private int fakeNumber;

    public FakeRandomAbstractNumberFactory(int fakeNumber) {
        this.fakeNumber = fakeNumber;
    }

    @Override
    public RangeableRandomNumber produce() {
        return new RangeableRandomNumber(this.fakeNumber);
    }

}
