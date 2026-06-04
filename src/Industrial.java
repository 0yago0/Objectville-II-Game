public class Industrial extends BaseZone {
    public Industrial() {

        super();
    }

    @Override
    public int calculateOutput() {
        int currentLevel = getLevel();
        int currentM = getM();

        if (currentLevel == 0)
            return 0;
        if (currentLevel == 1)
            return currentM;
        if (currentLevel == 2)
            return 2 * currentM;
        return 2 * currentM;
    }

    @Override
    public void updateLevel() {
        if (getM() == 0 && getLevel() > 0) {
            setLevel(0);
            return;
        }
        int currentLevel = getLevel();
        if (currentLevel == 0) {
            if (getM() > 0) {
                setLevel(1);
            }
        } else if (currentLevel == 1) {
            if (getM() > 0) {
                setLevel(2);
            }
        }
    }
}