package model;

// Represents the entire city map and manages all cells

public class City {
    private CityCell[][] grid;
    private int rows;
    private int cols;

    public City(int rows , int cols){
        this.rows = rows;
        this.cols = cols;
        this.grid = new CityCell[rows][cols];
    }

    public void setCell(int rows , int cols , CityCell cell){
        this.grid[rows][cols] = cell;
    }

    public CityCell getCell(int rows , int cols){
        return this.grid[rows][cols];
    }
    public int getCols() {
        return cols;
    }
    public int getRows() {
        return rows;
    }
}
