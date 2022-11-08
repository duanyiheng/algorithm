package leetcode.editor.en;
//Given an integer n, return an array ans of length n + 1 such that for each i (
//0 <= i <= n), ans[i] is the number of 1's in the binary representation of i. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// It is very easy to come up with a solution with a runtime of O(n log n). Can 
//you do it in linear time O(n) and possibly in a single pass? 
// Can you do it without using any built-in function (i.e., like __builtin_
//popcount in C++)? 
// 
//
// Related Topics Dynamic Programming Bit Manipulation 👍 8016 👎 378

public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            int[] ret = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                /**
                 * API solution
                 * ret[i] = Integer.bitCount(i);
                 */
                // DP solution
                ret[i] = ret[i & (i - 1)] + 1;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}