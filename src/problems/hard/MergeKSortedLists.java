package problems.hard;

import problems.easy.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    /***
     * #23. Merge k Sorted Lists - HARD
     * https://leetcode.com/problems/merge-k-sorted-lists/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/Y5n0n3vAgYK
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode l : lists){
            if(l!=null){
                minHeap.add(l);
            }
        }

        ListNode result =  new ListNode();
        ListNode resultLast = result;
        while(!minHeap.isEmpty()){
            ListNode current = minHeap.poll();
            resultLast.next = new ListNode(current.val);
            resultLast = resultLast.next;
            current = current.next;
            if(current!=null){
                minHeap.add(current);
            }
        }
        return result.next;
    }
}


