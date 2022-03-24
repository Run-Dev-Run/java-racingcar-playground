public class FakeRandomNumberFactory extends AbstractRandomNumberFactory {

    private int fakeNumber;

    public FakeRandomNumberFactory(int fakeNumber) {
        this.fakeNumber = fakeNumber;
    }

    @Override
    public RangeableRandomNumber produce() {
        return new RangeableRandomNumber(this.fakeNumber);
    }

}
