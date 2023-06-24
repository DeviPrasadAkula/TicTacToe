package TicTocToe.Strategies.BotPlayingStrategies;

import TicTocToe.Models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategies{


    //Playing strategy what we are following here is
    // Bot will place symbol when it reaches first empty cell while doing iteration

    @Override
    public Move decideNextMove(Player player, Board board) {
        for(int row=0; row<board.getBoard().size(); row++){
            for(int col=0; col<board.getBoard().size(); col++){
                if(board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.Empty)){
                    return new Move(player,new Cell(row,col));
                }
            }
        }
        return null;
    }
}
