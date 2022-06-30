package problems.medium;

import problems.easy.ListNode;

import java.util.HashSet;

public class LinkedListCycleII {
    /**
     * #142. Linked List Cycle II
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            if(!set.contains(head)){
                set.add(head);
                head = head.next;
            }else{
                return head;
            }
        }
        return null;
    }
}