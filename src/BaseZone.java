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

    public abstract int calculateOutput();

    public abstract void updateLevel();
}
