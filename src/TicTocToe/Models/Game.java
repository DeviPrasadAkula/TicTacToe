package TicTocToe.Models;

import TicTocToe.Exceptions.InvalidGameException;
import TicTocToe.Strategies.GamewinningStrategies.GameWinningStrategy;
import TicTocToe.Strategies.GamewinningStrategies.OptimisedGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int  nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    public void setWinner(Player winner){
        this.winner=winner;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }



    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void getNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void displayBoard(){
        this.board.display();
    }
    public void executeNextMove(){
        Player playertoMove=players.get(nextPlayerIndex);
        System.out.println("Player "+playertoMove.getName()+" is Making the Move");

        //Lets make player to decide next move
        Move move=playertoMove.decideNextMove(this.board);
        //It returns new Cell with player and row,col Information0
        Cell cell=move.getCell();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        //Validation
        //If the cell is empty or not?
        if(board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.Empty)){
           // cell.setCellStatus(CellStatus.Filled);
            // cell.setPlayer(playertoMove);
            //make the board-cell filled
            board.getBoard().get(row).get(col).setCellStatus(CellStatus.Filled);
            board.getBoard().get(row).get(col).setPlayer(playertoMove);
            moves.add(move);

            if(gameWinningStrategy.checkWinner(board,playertoMove,cell)){
                gameStatus=GameStatus.End;
                setWinner(playertoMove);
            }
            nextPlayerIndex++;
            nextPlayerIndex%=(players.size());

        }else{
            System.out.println("The cell is already filled. Please enter valid row and Column");
        }

    }
    public Player getwinner(){
        return winner;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    //Let's create builder class since validations are required before creation of Game  Object


    public static class Builder{
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }



       private Boolean isValid() throws InvalidGameException {
            if(dimension<3){
                throw new InvalidGameException("Dimension should not less than 3");
            }
            if(players.size()!=dimension-1){
                throw new InvalidGameException("Number of Players should be equal to dimension-1");
            }
            return true;
        }


        public Game build() throws InvalidGameException{

            try{
                isValid();
            }catch(Exception e){
                throw new InvalidGameException("Invalid Game Creation");
            }

            Game game=new Game();
            game.setGameStatus(GameStatus.InProgress);
            game.setPlayers(players);
            game.setBoard(new Board(dimension));
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OptimisedGameWinningStrategy(dimension));

            return game;

        }
    }
}
