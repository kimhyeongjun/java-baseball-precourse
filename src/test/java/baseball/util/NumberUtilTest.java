package baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {

  @Test
  void checkNumber() {
    assertAll(
      () -> assertTrue(NumberUtil.checkNumber("123")),
      () -> assertFalse(NumberUtil.checkNumber("1234")),
      () -> assertFalse(NumberUtil.checkNumber("123d")),
      () -> assertFalse(NumberUtil.checkNumber("123d**ㅇ"))
    );
  }
}