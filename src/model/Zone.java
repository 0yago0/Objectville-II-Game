package model;

//Base class for developable areas like Housing , Industrial , Commercial

public abstract class Zone extends CityCell {

    protected int level;
    protected int lastOutput;

    public Zone(int row , int col){
        super(row, col);
        this.level = 0;
        this.lastOutput = 0;
    }

    public int getLevel(){
        return level;
    }
    public int getLastOutput(){
        return lastOutput;
    }

    public abstract void processLevelUp();
    public abstract void calculateProduction();
}
