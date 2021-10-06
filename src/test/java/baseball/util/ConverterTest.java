package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

  @ParameterizedTest
  @DisplayName("숫자 형태의 문자열을 int 배열로 변환 테스트.")
  @CsvSource(value = {"123:3", "1231:4"}, delimiter = ':')
  void convertStringToIntArr(String numStr, int size) {
    int[] numbers = Converter.convertStringToIntArr(numStr);

    assertEquals(size, numbers.length);
  }
}