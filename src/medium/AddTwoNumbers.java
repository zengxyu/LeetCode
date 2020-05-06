package medium;

import java.util.ArrayList;

/**
 * Program: LeetCode
 * Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Author: Xiangyu Zeng
 * Create Time: 2020-05-06 20:44
 * Gain : ListNode 是可以从前往后遍历的，用head存最开始节点的引用，用last存最近节点的应用，last.next指下一个，last = last.next
 **/

import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode listNode = new ListNode(sum % 10);
            carry = sum / 10;
            if (head == null) {
                head = listNode;
                last = listNode;
            } else {
                last.next = listNode;
                last = listNode;
            }

        }
        if (carry == 1) {
            last.next = new ListNode(1);
        }

        return head;
    }
}
