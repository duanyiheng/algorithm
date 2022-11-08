package leetcode.editor.en;
//Given a positive integer, check whether it has alternating bits: namely, if 
//two adjacent bits will always have different values. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: true
//Explanation: The binary representation of 5 is: 101
// 
//
// Example 2: 
//
// 
//Input: n = 7
//Output: false
//Explanation: The binary representation of 7 is: 111. 
//
// Example 3: 
//
// 
//Input: n = 11
//Output: false
//Explanation: The binary representation of 11 is: 1011. 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics Bit Manipulation 👍 1069 👎 104

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int a = (n ^ (n >> 1));
            return 0 == (a & (a + 1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

