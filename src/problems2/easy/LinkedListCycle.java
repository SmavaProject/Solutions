package problems2.easy;

public class LinkedListCycle {

    //https://leetcode.com/problems/linked-list-cycle/

    public boolean hasCycle(problems.easy.ListNode head) {
        problems.easy.ListNode slow = head;
        problems.easy.ListNode fast = head;

        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast != null){
                if (slow == fast) return true;
            }
        }
        return false;
    }

}
