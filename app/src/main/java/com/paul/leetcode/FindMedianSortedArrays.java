package com.paul.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public static double solution(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        return (find(nums1,0,length1 -1,nums2,0,length2-1,(length1 + length2 + 1) / 2)
                + find(nums1,0,length1-1,nums2,0,length2-1,(length1 + length2) / 2 + 1)) / 2d;
    }

    private static int find(int[] nums1,int start1, int end1,int[] nums2, int start2,int end2,int cnt){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2){
            return find(nums2,start2,end2,nums1,start1,end1,cnt);
        }
        if (len1 == 0){
            return nums2[cnt + start2 -1];
        }

        if (cnt == 1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int pos1 = start1 + Math.min(cnt/2, len1) -1;
        int pos2 = start2 + cnt/2 -1;

        if (nums1[pos1] > nums2[pos2]){
            return find(nums1,start1,end1,nums2,pos2+1,end2,cnt - cnt/2);
        }else {
            return find(nums1,pos1+1,end1,nums2,start2,end2,cnt - Math.min(cnt/2, len1));
        }
    }
}
