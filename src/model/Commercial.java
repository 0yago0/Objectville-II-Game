package model;

// Concrete class representing commercial buildings like shops

public class Commercial extends Zone {

    public Commercial(int row , int col){
        super(row, col);
    }

    @Override
    public void processLevelUp(){
        // Logic for commercial growth will be added
    }
    @Override
    public void calculateProduction(){
        // Logic for commercial income will be added
    }


}
