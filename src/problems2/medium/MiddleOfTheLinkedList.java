package problems2.medium;

public class MiddleOfTheLinkedList  {

    //https://leetcode.com/problems/middle-of-the-linked-list/

    public problems.easy.ListNode middleNode(problems.easy.ListNode head) {
        problems.easy.ListNode slow = head;
        problems.easy.ListNode fast = head;

        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
