package com.paul.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    /**
     * 审题错误，该算法为最长不连续子串
     */
    public static String solution(String s){
        if (s == null || s.length() == 0){
            return s;
        }
        int length = s.length();
        int longest = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char child = s.charAt(i);
            if (map.containsKey(child)){
                int old = map.get(child);
                int temp = i - old;
                if (temp > longest){
                    longest = temp;
                    start = old;
                }
            }else {
                map.put(child,i);
            }
        }
        return s.substring(start, start + longest + 1);
    }
}
