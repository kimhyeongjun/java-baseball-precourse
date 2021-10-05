package baseball.util;

public final class Validator {

  private Validator() {}

  public static boolean checkInput(String numberStr) {
    return numberStr.matches("[0-9]+") && numberStr.length() == 3;
  }

}
