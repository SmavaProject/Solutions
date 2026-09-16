package problems2.easy;

public class MergeTwoSortedLists {

    //https://leetcode.com/problems/merge-two-sorted-lists/
    
    public problems.easy.ListNode mergeTwoLists(problems.easy.ListNode list1, problems.easy.ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        problems.easy.ListNode res = new problems.easy.ListNode(-1);
        problems.easy.ListNode result = res;

        while (list1 !=null && list2!=null){
            if (list1.val <= list2.val){
                res.next = new problems.easy.ListNode(list1.val);
                list1 = list1.next;
            }else{
                res.next = new problems.easy.ListNode(list2.val);
                list2 = list2.next;
            }
            res = res.next;
            if(list1 == null){
                res.next = list2;
            }
            if (list2 == null){
                res.next = list1;
            }
        }
        return result.next;
    }

}
