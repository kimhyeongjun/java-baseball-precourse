package baseball.util;

import baseball.controller.GameController;

import java.util.List;

public final class Validator {

  private Validator() {}

  public static boolean checkInput(final String numberStr) {
    return validateNumberFormat(numberStr) && validateLength(numberStr) && validateDuplicate(numberStr);
  }

  private static boolean validateNumberFormat(final String numberStr) {
    return numberStr.matches("[0-9]+");
  }

  private static boolean validateLength(final String numberStr) {
    return numberStr.length() == GameController.BALL_COUNT;
  }

  private static boolean validateDuplicate(final String numberStr) {
    return validateDuplicate(numberStr, 1);
  }

  private static boolean validateDuplicate(String numberStr, int index) {
    if (index >= numberStr.length()) {
      return Boolean.TRUE;
    }

    if (numberStr.charAt(index - 1) == numberStr.charAt(index)) {
      return Boolean.FALSE;
    }

    return validateDuplicate(numberStr, ++index);
  }

  public static boolean validateDuplicateList(final int item, List<Integer> target) {
    return target.contains(item);
  }

}
