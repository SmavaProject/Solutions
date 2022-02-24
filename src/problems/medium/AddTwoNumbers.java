package problems.medium;

import problems.easy.ListNode;

public class AddTwoNumbers {
    /***
     * #2. Add Two Numbers - MEDIUM
     * https://leetcode.com/problems/add-two-numbers/
     *
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pointer1 = 0;
        int pointer2 = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        boolean plusOne = false;
        while(c1 != null || c2 != null){
            int c1val = c1!=null ? c1.val : 0; //<--- assign 0 to val if the list is empty
            int c2val = c2!=null ? c2.val : 0; // for cases where l1 is shorter than l2
            int sum = plusOne==true ? c1val + c2val + 1 : c1val + c2val;

            if(sum>=10){
                result.next = new ListNode(sum%10);
                plusOne = true;
            }else{
                result.next = new ListNode(sum);
                plusOne = false;
            }
            if(c1!=null) c1 = c1.next;
            if(c2!=null) c2 = c2.next;
            result = result.next;
        }
        /**
         * To cover the cases like:
         * [9,9,9,9]
         * [9,9]
         * where there is a trailing 1 at the end
         */
        if(plusOne){
            result.next = new ListNode(1);
        }

        return dummy.next;
    }

}
