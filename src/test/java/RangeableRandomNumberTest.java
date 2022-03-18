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

    public final int MIN_RANDOM_NUMBER = 0;
    public final int MAX_RANDOM_NUMBER = 9;

    @ParameterizedTest
    @DisplayName("RandomNumber에 음수나 9 이상의 수가 주어진다면, 예외를 던집니다.")
    @ValueSource(ints = {-1, 10})
    void test_generate_RandomNumber_validate_invalid_number(int number) {
        assertThatThrownBy(() -> new RangeableRandomNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("RandomNumber는 0 이상 9이하의 난수로 생성됩니다.")
    void test_generate_random_number_range() {
        RangeableRandomNumber testBasicRangeableRandomNumber01 = new RangeableRandomNumber(1);
        RangeableRandomNumber testBasicRangeableRandomNumber02 = new RangeableRandomNumber(2);
        RangeableRandomNumber testBasicRangeableRandomNumber03 = new RangeableRandomNumber(3);

        assertAll(
            () -> assertTrue(testBasicRangeableRandomNumber01.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRandomNumber01.isLessThan(MAX_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRandomNumber02.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRandomNumber02.isLessThan(MAX_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRandomNumber03.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testBasicRangeableRandomNumber03.isLessThan(MAX_RANDOM_NUMBER))
        );
    }

    @ParameterizedTest
    @DisplayName("isMoreThan()는 RandomNumber가 주어진 파라미터 이상인지 검사합니다.")
    @CsvSource(value = {"4:true", "5:true", "6:false"}, delimiter = ':')
    void test_isMoreThan(int element, boolean expected) {
        RangeableRandomNumber basicRangeableRandomNumberFive = new RangeableRandomNumber(5);

        assertThat(basicRangeableRandomNumberFive.isMoreThan(element)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("isMoreThan()는 RandomNumber가 주어진 파라미터 이하인지 검사합니다.")
    @CsvSource(value = {"4:false", "5:true", "6:true"}, delimiter = ':')
    void test_isLessThan(int element, boolean expected) {
        RangeableRandomNumber basicRangeableRandomNumberFive = new RangeableRandomNumber(5);

        assertThat(basicRangeableRandomNumberFive.isLessThan(element)).isEqualTo(expected);
    }

}
