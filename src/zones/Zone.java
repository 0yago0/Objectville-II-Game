package zones;

import cells.Cell;

public abstract class Zone extends Cell {
    private boolean hasSecurity;
    private boolean hasHealth;
    private boolean hasEducation;

    public Zone(int row, int column) {
        super(row, column);
    }

    public boolean hasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public boolean hasHealth() {
        return hasHealth;
    }

    public void setHasHealth(boolean hasHealth) {
        this.hasHealth = hasHealth;
    }

    public boolean hasEducation() {
        return hasEducation;
    }

    public void setHasEducation(boolean hasEducation) {
        this.hasEducation = hasEducation;
    }

    public void resetServices() {
        this.hasSecurity = false;
        this.hasHealth = false;
        this.hasEducation = false;
    }
}
