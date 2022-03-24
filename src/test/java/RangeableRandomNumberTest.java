import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RandomNumber 단위테스트")
public class RangeableRandomNumberTest {

    public final int MIN_RANDOM_NUMBER = RangeableRandomNumberFactory.DEFAULT_MIN_RANDOM_NUMBER;
    public final int MAX_RANDOM_NUMBER = RangeableRandomNumberFactory.DEFAULT_MAX_RANDOM_NUMBER;

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void RandomNumber에_MIN_RANDOM_NUMBER_이하의_수_혹은_MAX_RANDOM_NUMBER_이상의_수가_주어진다면_예외를_던집니다(int number) {
        assertThatThrownBy(() -> new RangeableRandomNumber(number, MAX_RANDOM_NUMBER, MAX_RANDOM_NUMBER))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void RandomNumber는_MIN_RANDOM_NUMBER_이상_MAX_RANDOM_NUMBER_이하의_난수로_생성됩니다() {
        RangeableRandomNumber testBasicRangeableRangeableRandomNumber01 = new RangeableRandomNumber(1);
        RangeableRandomNumber testBasicRangeableRangeableRandomNumber02 = new RangeableRandomNumber(2);
        RangeableRandomNumber testBasicRangeableRangeableRandomNumber03 = new RangeableRandomNumber(3);

        assertAll(
            () -> assertTrue(testBasicRangeableRangeableRandomNumber01.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRangeableRandomNumber01.isLessThan(MAX_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRangeableRandomNumber02.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRangeableRandomNumber02.isLessThan(MAX_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRangeableRandomNumber03.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRangeableRandomNumber03.isLessThan(MAX_RANDOM_NUMBER))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "5:true", "6:false"}, delimiter = ':')
    void isMoreThan는_RandomNumber가_주어진_파라미터_이상인지_검사합니다(int element, boolean expected) {
        RangeableRandomNumber basicRangeableRangeableRandomNumberFive = new RangeableRandomNumber(5);

        assertThat(basicRangeableRangeableRandomNumberFive.isMoreThan(element)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:false", "5:true", "6:true"}, delimiter = ':')
    void isLessThan는_RandomNumber가_주어진_파라미터_이하인지_검사합니다(int element, boolean expected) {
        RangeableRandomNumber basicRangeableRangeableRandomNumberFive = new RangeableRandomNumber(5);

        assertThat(basicRangeableRangeableRandomNumberFive.isLessThan(element)).isEqualTo(expected);
    }

}
