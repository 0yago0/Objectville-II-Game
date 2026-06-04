public abstract class BaseZone {
    private int level;
    private int m;
    private int electricityReceived;
    private int waterReceived;
    private int internetReceived;
    private boolean hasSecurity;
    private boolean hasHealth;
    private boolean hasEducation;

    public BaseZone() {
        this.level = 0;
        this.electricityReceived = 0;
        this.internetReceived = 0;
        this.waterReceived = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level >= 0 && level <= 3) {
            this.level = level;
        }
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void updateUtilities(int e, int w, int i) {
        this.electricityReceived = e;
        this.waterReceived = w;
        this.internetReceived = i;
    }

    public void updateServices(boolean sec, boolean heal, boolean edu) {
        this.hasSecurity = sec;
        this.hasHealth = heal;
        this.hasEducation = edu;
    }

    public boolean hasSecurity() {
        return hasSecurity;
    }

    public boolean hasHealth() {
        return hasHealth;
    }

    public boolean hasEducation() {
        return hasEducation;
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

    public void receiveUtility(String utilityType, int amount) {
        if (utilityType.equals("electricity")) {
            electricityReceived += amount;
        } else if (utilityType.equals("water")) {
            waterReceived += amount;
        } else if (utilityType.equals("internet")) {
            internetReceived += amount;
        }
    }

    public int getUtilityDemand(String utilityType) {
        return 1;
    }

    public abstract int calculateOutput();

    public abstract void updateLevel();
}