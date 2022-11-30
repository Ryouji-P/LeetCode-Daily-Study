/**
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
**/
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        int odds = 0;
        for (int v = 0; v < s.length(); v++) {
            char currChar = s.charAt(v);
            count[currChar] += 1;
            odds += (count[currChar] & 1) == 1 ? 1 : -1;
        }
        return s.length() - odds + (odds > 0 ? 1 : 0);
    }
}
