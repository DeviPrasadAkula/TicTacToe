import TicTocToe.Controller.GameController;
import TicTocToe.Exceptions.InvalidGameException;
import TicTocToe.Models.*;
import TicTocToe.Strategies.BotPlayingStrategies.BotPlayingStrategies;
import TicTocToe.Strategies.BotPlayingStrategies.RandomBotPlayingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InvalidGameException {

        Scanner sc=new Scanner(System.in);

        System.out.println("Give the dimension of the Board");
        int Dimension=sc.nextInt();

        System.out.println("Is there any Bot player? Y/N");
        String isBotPlayer=sc.next();

        List<Player> players=new ArrayList<>();
        int size=Dimension-1;
        if(isBotPlayer.equals("Y")){
            size=Dimension-2;
        }
        //Get Name and Symbol from User and add the player into the player list
        for(int i=1; i<=size; i++){
            System.out.println("Enter the Name of the player"+ i);
            String PlayerName=sc.next();
            System.out.println("Enter the Symbol for player" + i);
            String symbol=sc.next();
            Player player=new Player(PlayerName,symbol.charAt(0));
            players.add(player);
        }
        //If the game has Bot
        //Lets player decide the name and Symbol for it
        if(isBotPlayer.equals("Y")){
            System.out.println("Enter the Name of the Bot");
            String PlayerName=sc.next();
            System.out.println("Enter the Symbol for Bot" );
            String symbol=sc.next();

            Bot bot=new Bot(PlayerName,symbol.charAt(0),PlyerDifficultyLevel.Easy);
            players.add(bot);
        }

        GameController gameController=new GameController();
        Game game=gameController.createGame(Dimension,players);

        //Play until game status is Inprogress
        while(gameController.getGameStatus(game).equals(GameStatus.InProgress)){
            System.out.println("This is the current Board");
            gameController.DisplayBoard(game);


                gameController.executeNextMove(game);

        }
        //While loop end when the Game is not in IN_PROGRESS

        System.out.println("Game has ended ");

        if(!gameController.getGameStatus(game).equals(GameStatus.Draw)){
            System.out.println("The winner is"+gameController.getWinner(game).getName());
        }



    }
}