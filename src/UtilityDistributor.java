import java.util.ArrayList;

public class UtilityDistributor {

    public void spreadUtility(BaseZone[][] grid, int startRow, int startCol, String utilityType, int capacity) {
        int rows = grid.length;
        int cols = grid[0].length;

        ArrayList<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];

        list.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!list.isEmpty() && capacity > 0) {

            int[] current = list.remove(0);

            int r = current[0];
            int c = current[1];

            BaseZone currentZone = grid[r][c];

            if (currentZone != null && currentZone.getClass().getSimpleName().equals("EmptyCell")) {
                continue;
            }

            if (currentZone != null && (r != startRow || c != startCol)) {
                int demand = currentZone.getUtilityDemand(utilityType);
                if (demand > 0) {
                    int supplied = Math.min(demand, capacity);
                    currentZone.receiveUtility(utilityType, supplied);
                    capacity -= supplied;
                }
            }

            if (r - 1 >= 0 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                list.add(new int[]{r - 1, c});
            }
            if (r + 1 < rows && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                list.add(new int[]{r + 1, c});
            }
            if (c - 1 >= 0 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                list.add(new int[]{r, c - 1});
            }
            if (c + 1 < cols && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                list.add(new int[]{r, c + 1});
            }
        }
    }
}