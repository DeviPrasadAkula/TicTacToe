package TicTocToe.Models;

import java.util.Scanner;

public class Player {
    private char Symbol;
    private String name;
    private PlayerType playerType;

    Player(){}

    public Player(String Name,char Symbol){
        this.name=Name;
        this.Symbol=Symbol;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideNextMove(Board board){
        Scanner sc=new Scanner(System.in);
        int row,col;
        System.out.println("Enter the Row index");
        row=sc.nextInt();
        System.out.println("Enter the Col index");
        col=sc.nextInt();

        return new Move(this,new Cell(row,col));

    }
}
