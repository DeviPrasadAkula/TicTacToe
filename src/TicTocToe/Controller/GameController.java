package TicTocToe.Controller;

import TicTocToe.Exceptions.InvalidGameException;
import TicTocToe.Models.Board;
import TicTocToe.Models.Game;
import TicTocToe.Models.GameStatus;
import TicTocToe.Models.Player;

import java.util.List;

public class GameController {
    //Contains all the methods to play the game
    //Optional since all the methods can also Create in respective classes based on the input parameters

    public void undo(){}
    public Game createGame(int Dimension, List<Player> players) throws InvalidGameException {
        Game game=Game.getBuilder()
                .setDimension(Dimension).setPlayers(players)
                .build();
        return game;
    }


    public void DisplayBoard(Game game){
         game.displayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public void executeNextMove(Game game){
         game.executeNextMove();
    }
    public Player getWinner(Game game){
        return game.getwinner();
    }



}
