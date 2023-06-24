package TicTocToe.Strategies.GamewinningStrategies;

import TicTocToe.Models.Board;
import TicTocToe.Models.Cell;
import TicTocToe.Models.Player;

public interface GameWinningStrategy {

    boolean checkWinner(Board board, Player LastMovedplayer, Cell currentcell);
}
