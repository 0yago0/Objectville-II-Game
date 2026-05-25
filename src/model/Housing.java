package model;

// Concrete class representing residential buildings

public class Housing extends Zone {

    public Housing(int row , int col){
        super(row, col);
    }

    @Override
    public void processLevelUp(){
        // Logic for population based growth will be added
    }
    @Override
    public void calculateProduction(){
        // Logic for increasing population will be added
    }
}
