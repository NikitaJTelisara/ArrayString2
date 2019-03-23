import java.util.ArrayList;
import java.util.List;

public class noOfIslandsInAMatrix {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1'},
                {'0', '0', '0'},
                {'1', '1', '1'}};
        System.out.print(numIslands(grid));


    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue q = new Queue();
                    Cell c = new Cell(i, j);
                    q.push(c);
                    while (!q.isEmpty()) {
                        Cell c1 = q.pop();
                        grid[c1.x][c1.y] = 0;
                        List<Cell> neigh = neigh(c1, grid);
                        for (int k = 0; k < neigh.size(); k++) {
                            q.push(neigh.get(k));
                        }
                    }
                }
            }
        }
        return count;
    }

    public static List<Cell> neigh(Cell c, char[][] grid) {
        int x = -1;
        int y = -1;
        List<Cell> lis = new ArrayList<Cell>();
        x = c.x - 1;
        y = c.y;

        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (grid[x][y] == '1') {
                lis.add(new Cell(x, y));
            }
        }

        x = c.x + 1;
        y = c.y;

        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (grid[x][y] == '1') {
                lis.add(new Cell(x, y));
            }
        }

        x = c.x;
        y = c.y + 1;

        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (grid[x][y] == '1') {
                lis.add(new Cell(x, y));
            }
        }

        x = c.x;
        y = c.y - 1;

        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (grid[x][y] == '1') {
                lis.add(new Cell(x, y));
            }
        }

        return lis;
    }
}
