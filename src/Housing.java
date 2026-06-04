public class Housing extends BaseZone {
    public Housing() {

        super();
    }

    @Override
    public int calculateOutput() {
        int currentLevel = getLevel();
        int currentM = getM();
        if (currentLevel == 0) {
            return 0;
        } else if (currentLevel == 1) {
            return currentM;
        } else if (currentLevel == 2) {
            return 2 * currentM;
        } else if (currentLevel == 3) {
            return 2 * currentM;
        }
        return 0;
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
            if (hasSecurity() && hasHealth() && hasEducation()) {
                setLevel(2);
            }
        } else if (currentLevel == 2) {
            if (getM() > 0) {
                setLevel(3);
            }
        }
    }
}