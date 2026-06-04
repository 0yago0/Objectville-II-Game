public class PoliceStation extends BaseZone {
    public PoliceStation() {
        super();
    }

    public int getRange() {
        return 5;
    }

    @Override
    public int calculateOutput() {
        return 0;
    }

    @Override
    public void updateLevel() {
    }
}
