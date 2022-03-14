import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.commons.function.Try.success;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RandomNumber 단위테스트")
public class RandomNumberTest {

    public final int MIN_RANDOM_NUMBER = 0;
    public final int MAX_RANDOM_NUMBER = 9;

    @DisplayName("0이상 9 이하의 수가 주어진다면, 해당 수 만큼의 RandomNumber 객체가 생성됩니다.")
    void test_generate_RandomNumber_validate_valid_number() {
        int validNumber = 3;

        success(new RandomNumber(validNumber));
    }

    @ParameterizedTest
    @DisplayName("RandomNumber에 음수나 9 이상의 수가 주어진다면, 예외를 던집니다.")
    @ValueSource(ints = {-1, 10})
    void test_generate_RandomNumber_validate_invalid_number(int number) {
        assertThatThrownBy(() -> new RandomNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("RandomNumber는 0 이상 9이하의 난수로 생성됩니다.")
    void test_generate_random_number_range() {
        RandomNumber testRandomNumber01 = new RandomNumber();
        RandomNumber testRandomNumber02 = new RandomNumber();
        RandomNumber testRandomNumber03 = new RandomNumber();

        assertAll(
            () -> assertTrue(testRandomNumber01.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testRandomNumber01.isLessThan(MAX_RANDOM_NUMBER)),
            () -> assertTrue(testRandomNumber02.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testRandomNumber02.isLessThan(MAX_RANDOM_NUMBER)),
            () -> assertTrue(testRandomNumber03.isMoreThan(MIN_RANDOM_NUMBER)),
            () -> assertTrue(testRandomNumber03.isLessThan(MAX_RANDOM_NUMBER))
        );
    }

    @ParameterizedTest
    @DisplayName("isMoreThan()는 RandomNumber가 주어진 파라미터 이상인지 검사합니다.")
    @CsvSource(value = {"4:true", "5:true", "6:false"}, delimiter = ':')
    void test_isMoreThan(int element, boolean expected) {
        RandomNumber randomNumberFive = new RandomNumber(5);

        assertThat(randomNumberFive.isMoreThan(element)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("isMoreThan()는 RandomNumber가 주어진 파라미터 이하인지 검사합니다.")
    @CsvSource(value = {"4:false", "5:true", "6:true"}, delimiter = ':')
    void test_isLessThan(int element, boolean expected) {
        RandomNumber randomNumberFive = new RandomNumber(5);

        assertThat(randomNumberFive.isLessThan(element)).isEqualTo(expected);
    }

}
