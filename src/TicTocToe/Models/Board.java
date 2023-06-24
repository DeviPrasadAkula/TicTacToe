package TicTocToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void display(){
        //get the dimension
        int Dimension=getBoard().size();

        for(int row=0; row<Dimension; row++){
            for(int col=0; col<Dimension; col++){
                //If cell is filled
                if(board.get(row).get(col).getCellStatus().equals(CellStatus.Filled)){
                    System.out.print("| "+board.get(row).get(col).getPlayer().getSymbol()+" |");
                }else{
                    System.out.print("|  |");
                }
            }
            System.out.println("");
        }
    }

    public Board(int dimension){
        this.board=new ArrayList<>();

        for(int row=0; row<dimension; row++){
            this.board.add(new ArrayList<>());
            for(int col=0; col<dimension; col++){
                this.board.get(row).add(new Cell(row,col));

            }
        }

    }



}
