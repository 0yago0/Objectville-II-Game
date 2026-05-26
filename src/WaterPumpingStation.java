public class WaterPumpingStation extends Utility{
    public WaterPumpingStation(int row,int column){
        super(row,column);
    }
    @Override
    public String getUtilityType(){
        return "water";
    }
}
