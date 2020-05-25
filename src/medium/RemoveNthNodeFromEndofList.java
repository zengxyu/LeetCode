package medium;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head
 */
public class RemoveNthNodeFromEndofList {
    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        int len = 1;
        while ((node = node.next) != null) {
            len++;
        }
        if (len == 1) {
            return null;
        }
        System.out.println("len:" + len);
        int delete_index = len - n;
        System.out.println("delete_index:" + delete_index);
        ListNode node2 = head;
        ListNode current = head;
        int count = 1;
        if (delete_index == 0){
            head = head.next;
        }else {
            while ((node2= node2.next) != null) {
                if (count != delete_index) {
                    current.next = node2;
                    current = current.next;
                }
                count++;
            }
            current.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
