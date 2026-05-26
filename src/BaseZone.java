public class BaseZone {
    private int electricityReceived;
    private int waterReceived;
    private int internetReceived;

    public BaseZone() {
        this.electricityReceived = 0;
        this.internetReceived = 0;
        this.waterReceived = 0;
    }

    public int getElectricityReceived() {
        return electricityReceived;
    }

    public void setElectricityReceived(int electricityReceived) {
        this.electricityReceived = electricityReceived;
    }

    public int getInternetReceived() {
        return internetReceived;
    }

    public void setInternetReceived(int internetReceived) {
        this.internetReceived = internetReceived;
    }

    public int getWaterReceived() {
        return waterReceived;
    }

    public void setWaterReceived(int waterReceived) {
        this.waterReceived = waterReceived;
    }

    public void receiveUtility(String utilityType, int amount){
        if (utilityType.equals("electricity" )){
            electricityReceived +=amount;
        } else if (utilityType.equals("water")) {
            waterReceived +=amount;
        } else if (utilityType.equals("internet")) {
            internetReceived +=amount;
        }
    }
    public int getUtilityDemand(String utilityType){
        return 1;
    }
}
