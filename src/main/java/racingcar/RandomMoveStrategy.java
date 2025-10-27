package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy {
    public boolean canMove() {
        int n = Randoms.pickNumberInRange(0, 9);
        return n >= 4;
    }
}
