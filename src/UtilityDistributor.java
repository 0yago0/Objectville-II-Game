import java.util.*;
public class UtilityDistributor {
    public void spreadUtility(Utility utility){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[10][20];

        int startRow= utility.getRow();
        int startColumn= utility.getColumn();

        queue.add(new int[]{startRow,startColumn});
        visited[startRow][startColumn]=true;
        while (!queue.isEmpty()){
            int [] current=queue.remove();

            int row=current[0];
            int column=current[1];

            if (row -1>=0 && ! visited[row-1][column]){
                visited[row - 1][column] = true;
                queue.add(new int[]{row - 1, column});
            }
            if (row + 1 < 10 && !visited[row + 1][column]) {
                visited[row + 1][column] = true;
                queue.add(new int[]{row + 1, column});
            }
            if (column - 1 >= 0 && !visited[row][column - 1]) {
                visited[row][column - 1] = true;
                queue.add(new int[]{row, column - 1});
            }
            if (column + 1 < 20 && !visited[row][column + 1]) {
                visited[row][column + 1] = true;
                queue.add(new int[]{row, column + 1});
            }
        }
        }
    }









