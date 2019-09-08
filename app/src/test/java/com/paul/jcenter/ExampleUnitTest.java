package com.paul.jcenter;

import com.paul.leetcode.TwoSum;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void twoSum(){
        int[] nums = {-2, -1, 0, 1, 3, 4, 5, 8};
        int[] nums1 = {-2, -1, 0, 1, 4, 5, 8};
        assertArrayEquals( new int[]{1,7},TwoSum.solution1(nums,7));
        assertArrayEquals( new int[]{0,6},TwoSum.solution1(nums1,6));
    }
}