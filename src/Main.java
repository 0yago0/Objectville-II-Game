public class Main {
    public static void main(String[] args) {
        // Default values if no arguments are provided
        String path = "harita.txt";
        int ticks = 3;

        // Command line arguments check as requested in the document
        if (args.length >= 2) {
            path = args[0];
            try {
                ticks = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid tick count. Using default: 3");
            }
        }

        try {
            System.out.println("Loading Map: " + path + " ---");
            BaseZone[][] grid = MapReader.readMapFile(path);

            int rows = grid.length;
            int cols = grid[0].length;
            System.out.println("Map loaded " + rows + "x" + cols);

            CityManager manager = new CityManager(grid);

            // Optimized for legacy execution review
            for (int turn = 1; turn <= ticks; turn++) {
                System.out.println("=== TURN " + turn + " ===");

                manager.resetInfrastructure();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (grid[i][j] instanceof PowerPlant) {
                            manager.spreadUtilityFrom(i, j);
                        }
                        if (grid[i][j] instanceof WaterPumpingStation) {
                            manager.spreadUtilityFrom(i, j);
                        }
                        if (grid[i][j] instanceof InternetHub) {
                            manager.spreadUtilityFrom(i, j);
                        }
                    }
                }

                manager.applyPolice();
                manager.applySchool();
                manager.applyHospital();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (grid[i][j] instanceof Commercial) {
                            Commercial comm = (Commercial) grid[i][j];
                            comm.setResourcesReceived(15, 10);
                        }
                    }
                }

                int totalScore = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        grid[i][j].updateLevel();
                        totalScore = totalScore + grid[i][j].calculateOutput();
                    }
                }

                System.out.println("Total output this turn: " + totalScore);
            }

            System.out.println("SIMULATION FINISHED");

        } catch (SE116ConfigurationException e) {
            System.out.println("Configuration Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}