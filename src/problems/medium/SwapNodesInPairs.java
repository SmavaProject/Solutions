package problems.medium;

import problems.easy.ListNode;

public class SwapNodesInPairs {
    /***
     * 24. Swap Nodes in Pairs
     * https://leetcode.com/problems/swap-nodes-in-pairs/

     * 1) Всегда когда делаем своп начинаем с previous node, иначе: Found cycle in the ListNode
     * 2) Всегда нужно помнить как предыдущий node присоединяется к текущему (или текущей паре как в этой задаче)
     */
    public ListNode swapPairs(ListNode head) {

        if(head== null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head.next;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode previousNode = new ListNode(-1);
        while(curr!=null){
            swap (curr, prev);

            previousNode.next = curr; //<<<------- присоединяет текущюю пару к "предыдущему" node
            previousNode = prev; //<<<------- запоминает новый "предыдущий" node

            prev = prev.next;
            if(prev!=null){
                curr = prev.next;
            }else{
                break;
            }
        }

        return  dummy.next;
    }

    //попарно меняет nodes местами
    private void swap (ListNode curr, ListNode prev){
        ListNode tmp = curr;

        prev.next = tmp.next; // ALWAYS start with PREVIOUS node
        curr.next = prev;
    }
}