package baseball.util;

public final class Converter {

  private Converter() {}

  public static int[] convertStringToIntArr(String numberStr) {
    int[] inputNums = new int[numberStr.length()];
    int tempNumber = Integer.parseInt(numberStr);

    for (int i = numberStr.length() - 1; i >= 0; i--) {
      inputNums[i] = tempNumber % 10;
      tempNumber /= 10;
    }

    return inputNums;
  }
}
