package leetcode.editor.en;
//There is only one character 'A' on the screen of a notepad. You can perform 
//one of two operations on this notepad for each step: 
//
// 
// Copy All: You can copy all the characters present on the screen (a partial 
//copy is not allowed). 
// Paste: You can paste the characters which are copied last time. 
// 
//
// Given an integer n, return the minimum number of operations to get the 
//character 'A' exactly n times on the screen. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: Initially, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics Math Dynamic Programming 👍 2938 👎 179

public class TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new TwoKeysKeyboard().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * <p>
         * We can break our moves into groups of (copy, paste, ..., paste). Let C denote copying and P denote pasting. Then for example, in the sequence of moves CPPCPPPPCP, the groups would be [CPP][CPPPP][CP].
         * <p>
         * Say these groups have lengths g_1, g_2, .... After parsing the first group, there are g_1 'A's. After parsing the second group, there are g_1 * g_2 'A's, and so on. At the end, there are g_1 * g_2 * ... * g_n 'A's.
         * <p>
         * We want exactly N = g_1 * g_2 * ... * g_n. If any of the g_i are composite, say g_i = p * q, then we can split this group into two groups (the first of which has one copy followed by p-1 pastes, while the second group having one copy and q-1 pastes).
         * <p>
         * Such a split never uses more moves: we use p+q moves when splitting, and pq moves previously. As p+q <= pq is equivalent to 1 <= (p-1)(q-1), which is true as long as p >= 2 and q >= 2.
         * <p>
         * Algorithm By the above argument, we can suppose g_1, g_2, ... is the prime factorization of N, and the answer is therefore the sum of these prime factors.
         */
        public int minSteps(int n) {
            int ans = 0;
            int d = 2;
            while (n > 1) {
                while (n % d == 0) {
                    ans += d;
                    n /= d;
                }
                d++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public int minStepsDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // initialize it with the worst case, CP...P(i operations in total)
            dp[i] = i;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    break;
                }
            }
        }
        return dp[n];
    }

}