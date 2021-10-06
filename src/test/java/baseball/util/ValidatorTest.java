package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

  @ParameterizedTest
  @DisplayName("사용자 입력 데이터 검증 테스트.")
  @CsvSource(value = {"123:true", "1234:false", "123d:false"}, delimiter = ':')
  void checkInput(String str, String result) {
    assertEquals(Boolean.parseBoolean(result), Validator.checkInput(str));
  }

  @ParameterizedTest
  @DisplayName("중복 체크 테스트.")
  @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
  void validateDuplicateList(int num, String expectResult) {
    List<Integer> nums = Arrays.asList(1,3,4);
    assertEquals(Boolean.valueOf(expectResult), nums.contains(num));

  }
}