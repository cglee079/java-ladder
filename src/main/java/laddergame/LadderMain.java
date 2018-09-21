package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.*;

public class LadderMain {
    public static void main(String[] args) {
        String person = InputView.getName();
        int height = InputView.getLadder();
        LadderGame ladderGame = new LadderGame(person, height);
        ladderGame.run();
        ResultView.printResult(ladderGame);
    }
}
