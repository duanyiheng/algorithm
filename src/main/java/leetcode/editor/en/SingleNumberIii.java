package leetcode.editor.en;
//Given an integer array nums, in which exactly two elements appear only once 
//and all the other elements appear exactly twice. Find the two elements that 
//appear only once. You can return the answer in any order. 
//
// You must write an algorithm that runs in linear runtime complexity and uses 
//only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,3,2,5]
//Output: [3,5]
//Explanation:  [5, 3] is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0]
//Output: [-1,0]
// 
//
// Example 3: 
//
// 
//Input: nums = [0,1]
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each integer in nums will appear twice, only two integers will appear once. 
// 
//
// Related Topics Array Bit Manipulation 👍 4479 👎 202

public class SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xorOfTheTwo = 0;
            for (int i = 0; i < nums.length; i++) {
                xorOfTheTwo ^= nums[i];
            }
            int[] res = new int[2];
            int firstDiff = xorOfTheTwo & (-xorOfTheTwo);
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if ((cur & firstDiff) == 0) {
                    res[0] ^= cur;
                } else {
                    res[1] ^= cur;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

