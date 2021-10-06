package baseball.util;

public final class Printer {

  private Printer() {}

  public static void printf(String message, Object... args) {
    System.out.printf(message + "\n", args);
  }

  public static void println(String message) {
    System.out.println(message);
  }

  public static void print(String message) {
    System.out.print(message);
  }

}
