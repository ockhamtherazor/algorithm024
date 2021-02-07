/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] charCount = new int[26];
        for (char c : s.toCharArray())
            charCount[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (charCount[c - 'a'] == 0)
                return false;
            charCount[c - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0)
                return false;
        }

        return true;
    }
}
// @lc code=end
