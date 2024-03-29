package com.paul.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    /**
     * 执行结果：通过
     * 显示详情
     *      执行用时 : 37 ms, 在所有 Java 提交中击败了 54.02% 的用户
     *      内存消耗 : 37.3 MB, 在所有 Java 提交中击败了 89.82% 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int A = target - nums[i];
            for (int j = i+1; j < length; j++) {
                if (A == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    /**
     * 执行结果：通过
     * 显示详情
     *  执行用时 : 5 ms , 在所有 Java 提交中击败了 96.24% 的用户
     *  内存消耗 : 38 MB, 在所有 Java 提交中击败了 77.05% 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target){
        int length = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>(length-1);
        for (int i = 0; i < length; i++) {
            int A = target - nums[i];
            if (hashMap.containsKey(A)){
                return new int[]{hashMap.get(A),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
