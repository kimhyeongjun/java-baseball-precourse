package baseball.util;

import baseball.controller.GameController;

import java.util.List;

public final class Validator {

  private Validator() {}

  public static boolean checkInput(final String numberStr) {
    return validateNumberFormat(numberStr) && validateLength(numberStr);
  }

  private static boolean validateNumberFormat(final String numberStr) {
    return numberStr.matches("[0-9]+");
  }

  private static boolean validateLength(final String numberStr) {
    return numberStr.length() == GameController.BALL_COUNT;
  }

  public static boolean validateDuplicateList(final int item, List<Integer> target) {
    return target.contains(item);
  }

}
