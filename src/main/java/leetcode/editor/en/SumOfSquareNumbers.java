package leetcode.editor.en;
//Given a non-negative integer c, decide whether there're two integers a and b 
//such that a² + b² = c. 
//
// 
// Example 1: 
//
// 
//Input: c = 5
//Output: true
//Explanation: 1 * 1 + 2 * 2 = 5
// 
//
// Example 2: 
//
// 
//Input: c = 3
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics Math Two Pointers Binary Search 👍 1462 👎 475

public class SumOfSquareNumbers{
    public static void main(String[] args){
      Solution solution = new SumOfSquareNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int i = 0;
            int j = (int) Math.sqrt(c);
            while (i <= j) {
                // i*i + j*j might be larger than Integer.MAX_VALUE
                int diff1 = c - j * j;
                int diff2 = i * i;
                if (diff1 == diff2) {
                    return true;
                } else if (diff1 > diff2) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
  }
