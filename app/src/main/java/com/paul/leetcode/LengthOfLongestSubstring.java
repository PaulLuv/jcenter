package com.paul.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    /**
     * 执行结果：通过
     * 执行用时 : 700 ms, 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗 : 66.7 MB, 在所有 Java 提交中击败了 13.43% 的用户
     * @param s
     * @return
     */
    public static int solution1(String s){
        int length = s.length();
        HashMap<Character,Integer> hashMap = new HashMap<>(length);
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (hashMap.containsKey(s.charAt(i))){
                if (result < hashMap.size()){
                    result = hashMap.size();
                }
                i = hashMap.get(s.charAt(i)) + 1;
                hashMap.clear();
            }
            hashMap.put(s.charAt(i),i);
        }
        if (result < hashMap.size()){
            result = hashMap.size();
        }
        return result;
    }

    /**
     * 执行结果：通过
     * 执行用时 : 22 ms, 在所有 Java 提交中击败了 74.93% 的用户
     * 内存消耗 : 48.9 MB, 在所有 Java 提交中击败了 36.04% 的用户
     * @param s
     * @return
     */
    public static int solution2(String s){
        String subString = "";
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            int index = subString.indexOf(a);
            if (index != -1){
                int length = subString.length();
                if (result < length){
                    result = length;
                }
                if (index == length -1){
                    subString = "";
                }else {
                    subString = subString.substring(index + 1, length);
                }
            }
            subString = subString.concat(String.valueOf(a));
        }
        if (result < subString.length()){
            result = subString.length();
        }
        return result;
    }


}
