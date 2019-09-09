package com.paul.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    /**
     * 执行结果：通过
     * 显示详情
     *      执行用时 : 4 ms, 在所有 Java 提交中击败了 97.19% 的用户
     *      内存消耗 : 48.3 MB, 在所有 Java 提交中击败了 65.04% 的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode result = null;
        ListNode currentNode = null;
        while (l1 != null && l2 != null) {
            add = l1.val + l2.val + add;
            if (currentNode == null) {
                currentNode = new ListNode(add % 10);
                result = currentNode;
            }else {
                currentNode.next = new ListNode(add % 10);
                currentNode = currentNode.next;
            }
            add = add / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            currentNode.next = new ListNode((l1.val + add) % 10);
            add = (l1.val + add) / 10;
            l1 = l1.next;
            currentNode = currentNode.next;
        }
        while (l2 != null){
            currentNode.next = new ListNode((l2.val + add) % 10);
            add = (l2.val + add) / 10;
            l2 = l2.next;
            currentNode = currentNode.next;
        }
        if (add != 0){
            currentNode.next = new ListNode(add);
        }
        return result;
    }

    /**
     * 执行结果：通过
     * 显示详情
     *      执行用时 : 6 ms, 在所有 Java 提交中击败了 76.20% 的用户
     *      内存消耗 : 44 MB, 在所有 Java 提交中击败了 87.51% 的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode result = null;
        ListNode currentNode = null;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            add = x + y + add;
            if (currentNode == null) {
                currentNode = new ListNode(add % 10);
                result = currentNode;
            }else {
                currentNode.next = new ListNode(add % 10);
                currentNode = currentNode.next;
            }
            add = add / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add != 0){
            currentNode.next = new ListNode(add);
        }
        return result;
    }
}
