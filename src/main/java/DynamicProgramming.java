import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DynamicProgramming {
    // 8.1 Triple Step
    public int tripleStep(int numStep) {
        // for nth step, the num will be (n - 1) + (n - 2) + (n - 3)
        // we can memoize the solution like this
        int[] dp = new int[numStep + 1];
        Arrays.fill(dp, -1);
        return tripleStep(numStep, dp);
    }

    // 8.1 helper
    private int tripleStep(int numStep, int[] dp) {
        if(numStep < 0) return 0;
        if(numStep == 0 || numStep == 1) return 1;
        if(dp[numStep] > -1) {
            return dp[numStep];
        }

        dp[numStep] = tripleStep(numStep - 1, dp)
                + tripleStep(numStep - 2, dp)
                + tripleStep(numStep - 3, dp);
        return dp[numStep];
    }

    // 8.2 Robots in a grid
    public ArrayList<Point> robotInGrid(boolean[][] grid) {
        // assume tha robot can move into cell with value 0, but cannot move into cell with value 1
        ArrayList<Point> paths = new ArrayList<>();
        HashSet<Point> failed = new HashSet<>();

        if(getPath(grid, grid.length - 1, grid[0].length - 1, paths, failed)) {
            return paths;
        }

        return null;
    }

    private boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> paths, HashSet<Point> failedPaths) {
        if(row < 0 || col < 0 || !grid[row][col]) return false;
        Point p = new Point(row, col);

        if(failedPaths.contains(p)) return false;

        boolean isOrigin = row == 0 && col == 0;
        if(isOrigin
                || getPath(grid, row - 1, col, paths, failedPaths)
                || getPath(grid, row, col - 1, paths, failedPaths)) {
            paths.add(p);
            return true;
        }

        failedPaths.add(p);
        return false;
    }

    public boolean isReachable(boolean[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return false;
        boolean[][] dp = new boolean[grid.length][grid[0].length];

        for(boolean[] row: dp) {
            Arrays.fill(row, false);
        }

        dp[0][0] = true;
        dp[0][1] = grid[0][1];
        dp[1][0] = grid[1][0];
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                if(grid[i][j]) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
