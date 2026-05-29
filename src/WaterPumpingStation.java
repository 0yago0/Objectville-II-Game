public class WaterPumpingStation extends BaseZone {
    public WaterPumpingStation() {
        super();
    }

    @Override
    public int calculateOutput() {
        return 100; // 100 birim su üret(sbt)
    }

    @Override
    public void updateLevel() {
    }
}