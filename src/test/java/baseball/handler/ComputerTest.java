package baseball.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

  private Computer computer;

  @BeforeEach
  void setUp() {
    computer = new Computer();
  }

  @Test
  @DisplayName("야구 게임 숫자 초기화 기능 테스트")
  void init() throws NoSuchFieldException, IllegalAccessException {
    Field field = computer.getClass().getDeclaredField("baseBalls");
    field.setAccessible(Boolean.TRUE);
    List<Integer> preNums = new ArrayList<>();
    preNums.add(1);
    preNums.add(2);
    preNums.add(3);
    field.set(computer, preNums);
    computer.init();
    assertTrue(computer.getBaseBalls().isEmpty());
  }

  @Test
  void createBaseBalls() {
    computer.init();
    computer.createBaseBalls();
    List<Integer> nums = computer.getBaseBalls();
    Set<Integer> set = new HashSet<>(nums);

    assertAll(
      () -> assertEquals(3, nums.size()),
      () -> assertEquals(set.size(), nums.size())
    );
  }
}