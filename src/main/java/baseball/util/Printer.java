package baseball.util;

public final class Printer {

  public void printf(String message, Object... args) {
    System.out.printf(message + "\n", args);
  }

  public void println(String message) {
    System.out.println(message);
  }

  public void print(String message) {
    System.out.print(message);
  }

}
