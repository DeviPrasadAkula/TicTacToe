package TicTocToe.Strategies.GamewinningStrategies;

import TicTocToe.Models.Board;
import TicTocToe.Models.Cell;
import TicTocToe.Models.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimisedGameWinningStrategy implements GameWinningStrategy{


        //For Every row,Column,Diagonal we need hashmap to store symbol and count of apperance
        //For 3*3 board we need 8 hashmaps
        //3-rows, 3-cols, 1-topleftDiagonal 1-toprightDiagonal

        List<HashMap<Character,Integer>> rowwisesymbols=new ArrayList<>();
        List<HashMap<Character,Integer>> colwisesymbols=new ArrayList<>();

        HashMap<Character,Integer> topleftDiagonalsymbols=new HashMap<>();
        HashMap<Character,Integer> topRighttDiagonalsymbols=new HashMap<>();

        public OptimisedGameWinningStrategy(int Dimension){
            for(int n=0; n<Dimension; n++){
                rowwisesymbols.add(new HashMap<>());
                colwisesymbols.add(new HashMap<>());
            }
        }

        boolean checktopleftDiagonalSymbol(int row, int col){
            return row == col;
        }

        boolean checktoprightDiagonalSymbol(int row, int col,int Dimension){
            return row+col == Dimension-1;
        }
    @Override
    public boolean checkWinner(Board board, Player LastMovedplayer, Cell currentcell) {

            int row=currentcell.getRow();
            int col=currentcell.getCol();
            char Symbol=LastMovedplayer.getSymbol();
            int Dimension=board.getBoard().size();

            if(!rowwisesymbols.get(row).containsKey(Symbol)){
                rowwisesymbols.get(row).put(Symbol,0);
            }
            rowwisesymbols.get(row).put(Symbol,rowwisesymbols.get(row).get(Symbol)+1);

        if(!colwisesymbols.get(col).containsKey(Symbol)){
            colwisesymbols.get(col).put(Symbol,0);
        }
        colwisesymbols.get(col).put(Symbol,colwisesymbols.get(col).get(Symbol)+1);

        if(checktopleftDiagonalSymbol(row,col)){
            if(!topleftDiagonalsymbols.containsKey(Symbol)){
                topleftDiagonalsymbols.put(Symbol,0);
            }
            topleftDiagonalsymbols.put(Symbol,topleftDiagonalsymbols.get(Symbol)+1);
        }

        if(checktoprightDiagonalSymbol(row,col,Dimension)){
            if(!topRighttDiagonalsymbols.containsKey(Symbol)){
                topRighttDiagonalsymbols.put(Symbol,0);
            }
            topRighttDiagonalsymbols.put(Symbol,topRighttDiagonalsymbols.get(Symbol)+1);
        }
        //If all row/col are filled with the Current playersymbol then he is the winner
        if(rowwisesymbols.get(row).get(Symbol)==Dimension){
            return true;
        }
        if(colwisesymbols.get(col).get(Symbol)==Dimension){
            return true;
        }

        //Check whether the cell is in Diagonal
        //Next check the symbol count with Board Dimension
        if(checktopleftDiagonalSymbol(row,col) && topleftDiagonalsymbols.get(Symbol)==Dimension){
            return true;
        }
        if(checktoprightDiagonalSymbol(row,col,Dimension) && topRighttDiagonalsymbols.get(Symbol)==Dimension){
            return true;
        }



        return false;
    }



}
