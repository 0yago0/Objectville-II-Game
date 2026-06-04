import java.util.ArrayList;

public class CityManager {
    private BaseZone[][] map;
    private int rows;
    private int cols;
    public CityManager(BaseZone[][] loadedMap) {
        this.map = loadedMap;
        this.rows = loadedMap.length;
        this.cols = loadedMap[0].length;
    }
    public void resetInfrastructure() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j].setM(0);
                map[i][j].updateServices(false, false, false);
            }
        }
    }
    public void spreadUtilityFrom(int startX, int startY) {
        map[startX][startY].setM(1);
        for (int loop = 0; loop < 5; loop++) {

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map[i][j].getM() == 1) {
                        if (i - 1 >= 0) {
                            checkAndSpread(map[i][j], map[i - 1][j]);
                        }
                        if (i + 1 < rows) {
                            checkAndSpread(map[i][j], map[i + 1][j]);
                        }
                        if (j - 1 >= 0) {
                            checkAndSpread(map[i][j], map[i][j - 1]);
                        }
                        if (j + 1 < cols) {
                            checkAndSpread(map[i][j], map[i][j + 1]);
                        }
                    }
                }
            }
        }
    }
    public void applyPolice() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (map[i][j] instanceof PoliceStation) {

                    for (int x = 0; x < rows; x++) {
                        for (int y = 0; y < cols; y++) {

                            if (manhattanDistance(i, j, x, y) <= 5) {

                                map[x][y].updateServices(
                                        true,
                                        map[x][y].hasHealth(),
                                        map[x][y].hasEducation()
                                );
                            }
                        }
                    }
                }
            }
        }
    }
    public void applyHospital() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (map[i][j] instanceof Hospital) {

                    for (int x = 0; x < rows; x++) {
                        for (int y = 0; y < cols; y++) {

                            if (manhattanDistance(i, j, x, y) <= 3) {

                                map[x][y].updateServices(
                                        map[x][y].hasSecurity(),
                                        true,
                                        map[x][y].hasEducation()
                                );
                            }
                        }
                    }
                }
            }
        }
    }
    public void applySchool() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (map[i][j] instanceof School) {

                    for (int x = 0; x < rows; x++) {
                        for (int y = 0; y < cols; y++) {

                            if (manhattanDistance(i, j, x, y) <= 4) {

                                map[x][y].updateServices(
                                        map[x][y].hasSecurity(),
                                        map[x][y].hasHealth(),
                                        true
                                );
                            }
                        }
                    }
                }
            }
        }
    }
        private void checkAndSpread (BaseZone current, BaseZone neighbor){
            if (neighbor.getM() == 1) {
                return;
            }
            boolean canSpread = false;

            if (current instanceof Road) {
                canSpread = true;
            }
            if (current instanceof PowerPlant) {
                canSpread = true;
            }
            if (current instanceof WaterPumpingStation) {
                canSpread = true;
            }
            if (current instanceof InternetHub) {
                canSpread = true;
            }
            if (canSpread == true) {

                if (neighbor instanceof Road) {
                    neighbor.setM(1);
                }
                if (neighbor instanceof Housing) {
                    neighbor.setM(1);
                }
                if (neighbor instanceof Commercial) {
                    neighbor.setM(1);
                }
                if (neighbor instanceof Industrial) {
                    neighbor.setM(1);
                }
            }
        }

        private int manhattanDistance(int row1, int column1,
                                      int row2, int column2){
        return Math.abs(row1-row2)
                + Math.abs(column1-column2);
        }
    }