public class PowerPlant extends Utility {
    public PowerPlant(int row,int column){
        super(row,column);
    }
@Override
    public String getUtilityType(){
        return "electricity";
}
}
