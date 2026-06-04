public class PowerPlant extends BaseZone {
    public PowerPlant() {
        super();
    }

    @Override
    public int calculateOutput() {
        return 100; //  100 birim elektrik üretir(sbt)
    }

    @Override
    public void updateLevel() {
    }
}