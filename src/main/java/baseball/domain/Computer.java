package baseball.domain;

import baseball.util.Validator;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.controller.GameController.*;

public class Computer {

  private List<Integer> baseBalls;

  public void init() {
    if (baseBalls != null) {
      baseBalls.clear();
      return;
    }
    baseBalls = new ArrayList<>();
  }

  public void createBaseBalls() {
    for (int i = 0; i < BALL_COUNT; i++) {
      baseBalls.add(i, createBall());
    }
  }

  private int createBall() {
    int num = Randoms.pickNumberInRange(1, 9);

    return Validator.validateDuplicateList(num, baseBalls) ? createBall() : num;
  }

  public List<Integer> getBaseBalls() {
    return baseBalls;
  }

}
