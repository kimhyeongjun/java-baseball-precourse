package baseball.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

  private final BaseballGame baseballGame = new BaseballGame();


  @Test
  @DisplayName("게임 숫자 생성 테스트")
  void createNumbers() throws IllegalAccessException, NoSuchFieldException {
    baseballGame.createNumbers();
    Field field = baseballGame.getClass().getDeclaredField("randomNumbers");
    field.setAccessible(Boolean.TRUE);

    List<Integer> nums = (List<Integer>) field.get(baseballGame);
    Set<Integer> set = new HashSet<>(nums);

    assertAll(
      () -> assertEquals(3, nums.size()),
      () -> assertEquals(nums.size(), set.size())
    );
  }
}