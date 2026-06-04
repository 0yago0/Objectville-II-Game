
public class ServiceManager {

    public void distributeServices(BaseZone[][] grid) {
        clearServices(grid);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] != null) {
                    String type = grid[r][c].getClass().getSimpleName();

                    if (type.equals("PoliceStation") || type.equals("Hospital") || type.equals("School")) {
                        spreadService(grid, r, c, type);
                    }
                }
            }
        }
    }

    private void clearServices(BaseZone[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] != null) {
                    grid[r][c].updateServices(false, false, false);
                }
            }
        }
    }

    private void spreadService(BaseZone[][] grid, int serviceRow, int serviceCol, String serviceType) {
        int radius = 3;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] != null) {
                    if (manhattanDistance(serviceRow, serviceCol, r, c) <= radius) {
                        applyService(serviceType, grid[r][c]);
                    }
                }
            }
        }
    }
    private int manhattanDistance(int row1, int column1, int row2, int column2) {
        return Math.abs(row1 - row2) + Math.abs(column1 - column2);
    }

    private void applyService(String serviceType, BaseZone zone) {
        if (serviceType.equals("PoliceStation")) {
            zone.updateServices(true, zone.hasHealth(), zone.hasEducation());
        } else if (serviceType.equals("Hospital")) {
            zone.updateServices(zone.hasSecurity(), true, zone.hasEducation());
        } else if (serviceType.equals("School")) {
            zone.updateServices(zone.hasSecurity(), zone.hasHealth(), true);
        }
    }
}