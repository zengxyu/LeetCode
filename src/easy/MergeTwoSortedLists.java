package easy;

import java.util.ArrayList;
import java.util.List;

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

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<>();
        while (l1 != null && l2 != null) {
            //如果l1和l2下一个都不为空，判断谁更??
            if (l1.val < l2.val) {
                //l1_next更小就把l1_next加入
                list.add(l1);
                l1 = l1.next;
            } else {
                list.add(l2);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            list.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2);
            l2 = l2.next;
        }
        if (list.size() != 0) {
            ListNode l = list.get(list.size() - 1);
            ListNode pre = list.get(list.size() - 1);
            for (int i = list.size() - 2; i >= 0; i--) {
                pre = list.get(i);
                pre.next = l;
                l = pre;
            }
            return pre;
        } else
            return null;
    }

    public static int[] string_arr_2_int_arr(String[] arr) {
        int[] int_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int_arr[i] = Integer.parseInt(arr[i].trim());
        }
        return int_arr;
    }

    public static void main(String[] args) {
//        String s = "[], [0]";
//        String[] lists = s.split(",");
//        String[] list1 = lists[0].split("->");
//        String[] list2 = lists[1].split("->");
//        int[] list_1 = string_arr_2_int_arr(list1);
//        int[] list_2 = string_arr_2_int_arr(list2);
//        ListNode l12 = new ListNode(list_1[2]);
//        ListNode l11 = new ListNode(list_1[1], l12);
//        ListNode l1 = new ListNode(list_1[0], l11);
//        ListNode l22 = new ListNode(list_2[2]);
//        ListNode l21 = new ListNode(list_2[1], l22);
//        ListNode l2 = new ListNode(list_2[0], l21);
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        mergeTwoSortedLists.mergeTwoLists(null, new ListNode(0));

    }
}
