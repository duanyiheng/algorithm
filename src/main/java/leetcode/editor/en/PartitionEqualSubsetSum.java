package leetcode.editor.en;
//Given a non-empty array nums containing only positive integers, find if the 
//array can be partitioned into two subsets such that the sum of elements in both 
//subsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics Array Dynamic Programming 👍 9322 👎 152

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * This problem is essentially to find whether there are several numbers in a set which are able to sum to a specific value (in this problem, the value is sum/2).
         * Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
         * If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.
         * Base case: dp[0][0] is true; (zero number consists of sum 0 is true)
         * Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]).
         * If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers.
         * Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
         * <p>
         * Then we can optimize the space to one dimension.
         *
         * @param nums
         * @return
         */
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum & 1) == 1) {
                return false;
            }
            sum = sum / 2;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int num : nums) {
                for (int w = sum; w >= num; w--) {
                    dp[w] = dp[w] || dp[w - num];
                }
            }
            return dp[sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}