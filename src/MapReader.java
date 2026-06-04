import model.MapConfigException;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapReader {
    public static BaseZone[][] readMapFile(String filePath) throws MapConfigException {
        {
            try {
                File file = new File(filePath);
                Scanner sc = new Scanner(file);
                if (!sc.hasNextInt()) {
                    throw new MapConfigException("Error: Map file is empty!");
                }

                int rows = sc.nextInt();
                int cols = sc.nextInt();

                BaseZone[][] grid = new BaseZone[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!sc.hasNext()) {
                            throw new MapConfigException("Error: Missing data in map file!");
                        }

                        String type = sc.next();
                        if (type.equals("H")) {
                            grid[i][j] = new Housing();
                        } else if (type.equals("I")) {
                            grid[i][j] = new Industrial();
                        } else if (type.equals("C")) {
                            grid[i][j] = new Commercial();
                        } else if (type.equals("P")) {
                            grid[i][j] = new PowerPlant();
                        } else if (type.equals("W")) {
                            grid[i][j] = new WaterPumpingStation();
                        } else if (type.equals("T")) {
                            grid[i][j] = new InternetHub();
                        } else if (type.equals("F")) {
                            grid[i][j] = new PoliceStation();
                        } else if (type.equals("D")) {
                            grid[i][j] = new Hospital();
                        } else if (type.equals("S")) {
                            grid[i][j] = new School();
                        } else if (type.equals("R")) {
                            grid[i][j] = new Road();
                        } else if (type.equals("E")) {
                            grid[i][j] = new EmptyCell();
                        } else {
                            throw new MapConfigException("Error: Unknown cell type: " + type);
                        }
                    }
                }
                sc.close();
                return grid;
            } catch (FileNotFoundException e) {
                throw new MapConfigException("Error: File not found!");
            }
        }
    }
}