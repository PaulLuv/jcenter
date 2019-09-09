package com.paul.jcenter;

import com.paul.leetcode.AddTwoNumbers;
import com.paul.leetcode.TwoSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void addTwoNumbers(){
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(2);
        AddTwoNumbers.ListNode l1next = new AddTwoNumbers.ListNode(4);
        AddTwoNumbers.ListNode l1nextnext = new AddTwoNumbers.ListNode(3);
        l1.next = l1next;
        l1next.next = l1nextnext;

        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode l2next = new AddTwoNumbers.ListNode(6);
        AddTwoNumbers.ListNode l2nextnext = new AddTwoNumbers.ListNode(4);
        l2.next = l2next;
        l2next.next = l2nextnext;

        AddTwoNumbers.ListNode l3 = new AddTwoNumbers.ListNode(7);
        AddTwoNumbers.ListNode l3next = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode l3nextnext = new AddTwoNumbers.ListNode(8);
        l3.next = l3next;
        l3next.next = l3nextnext;

        assertArrayEquals(listNodeToList(l3).toArray(),listNodeToList(AddTwoNumbers.addTwoNumbers1(l1,l2)).toArray());
    }

    public List listNodeToList(AddTwoNumbers.ListNode listNode){
        List<Integer> list = new ArrayList<>();
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}