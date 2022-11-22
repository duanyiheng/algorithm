package leetcode.editor.en;
//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which 
//evaluates to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be 
//target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics Array Dynamic Programming Backtracking 👍 8401 👎 302

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Let's assume that they are two parts in the nums. Part P all have '+' before and N all have '-' before.
         * Then we have
         * Sum(P)-sum(N) = target
         * Sum(P)+sum(N)+Sum(P)-sum(N) = target + Sum(P)+ sum(N) = target + Sum(nums)
         * 2 * Sum(P) = target + Sum(nums)
         * Sum(P) = 1/2 * (target + Sum(nums));
         *
         * @param nums
         * @param target
         * @return
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // When sum < Math.abs(target) OR (sum + target) is not a even number, it will never gonna make it.
            if (sum < (target < 0 ? -target : target) || ((sum + target) & 1) == 1) {
                return 0;
            }
            sum = (sum + target) >> 1;
            int[] dp = new int[sum + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
            return dp[sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}