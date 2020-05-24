package easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */


public class RemoveDuplicatesSortedList {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode current = head;
        while (node!=null && node.next != null){
            while (node.next != null&&node.next.val == node.val){
                node = node.next;
            }
            current.next = node.next;
            current = current.next;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
