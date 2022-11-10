package leetcode.editor.en;
//Given a m x n grid filled with non-negative numbers, find a path from top 
//left to bottom right, which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// Related Topics Array Dynamic Programming Matrix 👍 8960 👎 117

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // this solution does not alter the grid and use the minimum extra space but it is kind of difficult to understand than using a res[][].
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] res = new int[n];
            res[0] = grid[0][0];
            // fill the first row to initialize the res. Then we refresh the res row by row from the second row.
            for (int i = 1; i < n; i++) {
                res[i] = grid[0][i] + res[i - 1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        res[j] = res[j] + grid[i][j];
                    } else {
                        res[j] = Math.min(res[j - 1], res[j]) + grid[i][j];
                    }
                }
            }
            return res[n - 1];
        }

        // this version is not submitted. It is quick with no extra array or two-dimensional array used.
        public int minPathSumGridCanBeAltered(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 1; i < n; i++) {
                grid[0][i] = grid[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                grid[i][0] = grid[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
            return grid[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}