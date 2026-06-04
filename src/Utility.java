public abstract class Utility {

        private int capacity;
        private int row;
        private int column;

    public Utility( int row, int column) {
        this.capacity = 100;
        this.column = column;
        this.row = row;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void resetCapacity() {
            capacity = 100;
        }

        public boolean hasCapacity() {
            return capacity > 0;
        }

        public int useCapacity(int requestedAmount) {
            int givenAmount = Math.min(requestedAmount, capacity);
            capacity -= givenAmount;
            return givenAmount;
        }

        public abstract String getUtilityType();
    }

