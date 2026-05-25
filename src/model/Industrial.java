package model;

// Concrete class representing industrial buildings

public class Industrial extends Zone {

    public Industrial(int row , int col){
        super(row, col);
    }

    @Override
    public void processLevelUp(){
        // Logic for worker-based growth will be added
    }

    @Override
    public void calculateProduction(){
        // Logic for factory production will be added
    }
}
