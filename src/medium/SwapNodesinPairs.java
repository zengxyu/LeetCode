package medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class SwapNodesinPairs {
    private static class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode record;
        ListNode newList = new ListNode();
        ListNode curNode = newList;
        while (true){
            if (node == null){
                curNode.next = null;
                break;
            }
            if (node.next == null){
                curNode.next = node;
                curNode.next.next = null;
                break;
            }
            record = node.next.next;
            curNode.next = node.next;
            curNode.next.next = node;
            curNode = curNode.next.next;
            node = record;
        }
        return newList.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        SwapNodesinPairs swapNode = new SwapNodesinPairs();
        swapNode.swapPairs(head);


    }
}
