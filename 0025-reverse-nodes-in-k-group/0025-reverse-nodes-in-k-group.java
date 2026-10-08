class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            // 1. Check if there are at least k nodes remaining
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            // 2. Reverse current k-group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }

            // 3. Reconnect pointers
            ListNode tmp = groupPrev.next; // Old head becomes new tail
            groupPrev.next = kth;          // New head of the reversed group
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}