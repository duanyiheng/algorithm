package leetcode.editor.en;
//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics Array Binary Search Dynamic Programming 👍 15680 👎 287

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLISEasyToUnderstand(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int max;
            for (int i = 0; i < n; i++) {
                max = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        max = Math.max(max, dp[j] + 1);
                    }

                }
                dp[i] = max;
            }
            int ret = dp[0];
            for (int i = 1; i < n; i++) {
                ret = Math.max(ret, dp[i]);
            }
            return ret;
        }

        // this is a trick but fast solution
        // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int size = 0;
            for (int x : nums) {
                int i = 0;
                int j = size;
                while (i < j) {
                    int m = (i + j) / 2;
                    if (tails[m] < x) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                tails[i] = x;
                if (i == size) {
                    size++;
                }
            }
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}