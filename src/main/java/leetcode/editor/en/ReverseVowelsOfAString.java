package leetcode.editor.en;
//Write a function that takes a string as input and reverse only the vowels of a
// string. 
//
// Example 1: 
//
// 
//Input: "hello"
//Output: "holle"
// 
//
// 
// Example 2: 
//
// 
//Input: "leetcode"
//Output: "leotcede" 
// 
//
// Note: 
//The vowels does not include the letter "y". 
//
// 
// Related Topics Two Pointers String 
// 👍 769 👎 1234

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            if (s == null) {
                return s;
            }
            int n = s.length();
            if (n == 1) {
                return s;
            }
            int i = 0;
            int j = n - 1;
            char[] res = s.toCharArray();
            while (i <= j) {
                char ci = res[i];
                char cj = res[j];
                if (isNotVowel(ci)) {
                    i++;
                } else if (isNotVowel(cj)) {
                    j--;
                } else {
                    res[i++] = cj;
                    res[j--] = ci;
                }
            }
            return String.valueOf(res);
        }

        public boolean isNotVowel(char c) {
            return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

