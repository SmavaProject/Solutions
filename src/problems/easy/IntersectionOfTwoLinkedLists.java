package problems.easy;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    /***
     * #160. Intersection of Two Linked Lists
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
