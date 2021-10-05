package baseball.handler;

import baseball.vo.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

  private final BaseballGame baseballGame = new BaseballGame(3);

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

  @ParameterizedTest
  @DisplayName("입력 된 데이터별 테스트")
  @MethodSource("generateData")
  void doStart(int[] inputNums, int[] expectArr) throws NoSuchFieldException, IllegalAccessException {
    Field field = baseballGame.getClass().getDeclaredField("randomNumbers");
    field.setAccessible(Boolean.TRUE);

    List<Integer> randomNumbers = Arrays.asList(7, 8, 9);

    field.set(baseballGame, randomNumbers);

    GameResult gameResult = baseballGame.doStart(inputNums);
    GameResult expectResult =
      GameResult.builder()
        .strikeCount(expectArr[0])
        .ballCount(expectArr[1])
        .build();

    assertAll(
      () -> assertEquals(expectResult.getStrikeCount(), gameResult.getStrikeCount()),
      () -> assertEquals(expectResult.getBallCount(), gameResult.getBallCount())
    );
  }

  static Stream<Arguments> generateData() {
    return Stream.of(
      Arguments.of(new int[]{7, 1, 2}, new int[]{1, 0}),
      Arguments.of(new int[]{1, 7, 2}, new int[]{0, 1}),
      Arguments.of(new int[]{1, 2, 3}, new int[]{0, 0}),
      Arguments.of(new int[]{7, 1, 8}, new int[]{1, 1})
    );
  }

}