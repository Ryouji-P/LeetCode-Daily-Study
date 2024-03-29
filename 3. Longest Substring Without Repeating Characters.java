/**
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> chars = new HashMap<>();

        int ans = 0;

        for (int j = 0, i = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (chars.containsKey(c)) {
                i = Math.max(chars.get(c), i);
            }
            ans = Math.max(ans, j - i + 1);
            chars.put(c, j + 1);
        }

        return ans;
    }
}
