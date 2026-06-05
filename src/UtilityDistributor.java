import java.util.ArrayList;

public class UtilityDistributor {

    public void spreadUtility(Utility utility) {

        ArrayList<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[10][20];

        int startRow = utility.getRow();
        int startColumn = utility.getColumn();

        list.add(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;

        int index = 0;

        while (index < list.size()) {

            int[] current = list.get(index);

            int row = current[0];
            int column = current[1];

            index++;

            if (row - 1 >= 0 && !visited[row - 1][column]) {
                visited[row - 1][column] = true;
                list.add(new int[]{row - 1, column});
            }

            if (row + 1 < 10 && !visited[row + 1][column]) {
                visited[row + 1][column] = true;
                list.add(new int[]{row + 1, column});
            }

            if (column - 1 >= 0 && !visited[row][column - 1]) {
                visited[row][column - 1] = true;
                list.add(new int[]{row, column - 1});
            }

            if (column + 1 < 20 && !visited[row][column + 1]) {
                visited[row][column + 1] = true;
                list.add(new int[]{row, column + 1});
            }
        }
    }
}