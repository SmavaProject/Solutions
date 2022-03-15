package problems.easy;

public class RemoveLinkedListElementsRecursion {
    /***
     * #230. Remove Linked List Elements - EASY
     * https://leetcode.com/problems/remove-linked-list-elements/
     * RECURSIVE solution
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head; // <----- (!!!!)
        ListNode prev = dummy;
        ListNode curr = head;

        recursion(prev, curr, val);

        return dummy.next;
    }

    public void recursion(ListNode prev, ListNode curr, int val){
        if(curr==null){
            return;
        }
        if(curr.val == val){
            prev.next = curr.next;
            recursion(prev, curr.next, val); //<--
        }else{
            recursion(curr, curr.next, val); //<--
        }
    }
}

/***
 * 1) нужно соединить dummy и head
 * 2) curr - должен продвигаться всегда!!!!
 * 3) prev - продвигается если только ничего не нужно удалять. Если нужно - то он остается
 */
