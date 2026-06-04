public abstract class Utility {

    private int capacity;
    private int row;
    private int column;

    public Utility() {
        this.capacity = 100;
    }

    public Utility(int row, int column) {
        this.capacity = 100;
        this.row = row;
        this.column = column;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void resetCapacity() {
        this.capacity = 100;
    }

    public boolean hasCapacity() {
        return this.capacity > 0;
    }

    public int useCapacity(int requestedAmount) {
        int givenAmount = Math.min(requestedAmount, this.capacity);
        this.capacity -= givenAmount;
        return givenAmount;
    }

    public abstract String getUtilityType();
}