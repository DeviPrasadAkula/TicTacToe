package TicTocToe.Models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellStatus;

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }



    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell(int row, int col){
        this.row=row;
        this.col=col;
        this.cellStatus=CellStatus.Empty;
    }
    public Cell(int row,int col,CellStatus cellStatus){
        this.row=row;
        this.col=col;
        this.cellStatus=cellStatus;
    }


}
