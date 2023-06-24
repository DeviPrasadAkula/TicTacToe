package TicTocToe.Strategies.BotPlayingStrategies;

import TicTocToe.Models.Board;
import TicTocToe.Models.Move;
import TicTocToe.Models.Player;

public interface BotPlayingStrategies {
    public Move decideNextMove(Player player, Board board);
}
