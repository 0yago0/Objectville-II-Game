public class Hospital extends BaseZone {
    public Hospital() {
        super();
    }

    public int getRange() {
        return 3;
    }

    @Override
    public int calculateOutput() {
        return 0;
    }

    @Override
    public void updateLevel() {
    }
}
