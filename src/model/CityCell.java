package model;

// Base class for every element on the map grid

public abstract class CityCell {

    protected int row;
    protected int col;

    public CityCell(int row , int col){
        this.row = row;
        this.col =col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

}
