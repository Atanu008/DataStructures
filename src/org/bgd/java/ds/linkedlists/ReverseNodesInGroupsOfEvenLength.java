package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://www.educative.io/module/page/k5m3gACX33xvNPEvB/10370001/5966164452442112/5556023194288128">...</a>
 * Given the head of a linked list, the nodes in it are assigned to each group in a sequential manner. The length of these groups follows the sequence of natural numbers. Natural numbers are positive whole numbers denoted by
 * (1,2,3,4...)
 * Your task is to reverse the nodes in each group with an even number of nodes and return the head of the modified linked list.
 */
public class ReverseNodesInGroupsOfEvenLength {
    public LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {
        return head;
    }

    private LinkedListNode reverse(LinkedListNode head, int n) {
        LinkedListNode prev = null, curr = head;
        while (curr != null && n > 0) {
            LinkedListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
            n--;
        }
        return prev;
    }
}
