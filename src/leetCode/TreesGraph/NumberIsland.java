package leetCode.TreesGraph;

public class NumberIsland {
    private int numIslands(char[][] grid){
        if(grid.length == 0 || grid == null) return 0;
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    result = result + helper(grid, i, j);
                }
            }
        }

        return result;
    }

    private int helper(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;

        grid[i][j] = '0';
        helper(grid, i, j-1);
        helper(grid, i, j+1);
        helper(grid, i-1, j);
        helper(grid, i+1, j);

        return 1;
    }
}
