package cells;

public abstract class Cell {

    protected int row;
    protected int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }
}
