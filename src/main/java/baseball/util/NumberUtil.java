package baseball.util;

public final class NumberUtil {

  public static boolean checkNumber(String str) {
    return str.matches("[0-9]+") && str.length() == 3;
  }
}
