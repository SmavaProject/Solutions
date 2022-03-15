package problems.easy;

public class RemoveLinkedListElements {
    /***
     * #230. Remove Linked List Elements - EASY
     * https://leetcode.com/problems/remove-linked-list-elements/
     *
     */
        public ListNode removeElements(ListNode head, int val) {
            if(head==null){
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head; // <----- (!!!!)

            ListNode prev = dummy;
            ListNode curr = head;

            while(curr!=null){
                if(curr.val == val){
                    prev.next = curr.next;
                }else{
                    prev = curr;
                }
                curr = curr.next;
            }

            return dummy.next;
        }
    }

/***
 * 1) нужно соединить dummy и head
 * 2) curr - должен продвигаться всегда!!!!
 * 3) prev - продвигается если только ничего не нужно удалять. Если нужно - то он остается
 */
