package interviewQuestion;

public class MergeTwoSortedLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(-1);
        ListNode head=temp;
        while(l1!=null&&l2!=null){
         if(l1.val<l2.val) {
             temp.next = l1;
            l1=l1.next;
         }else{
             temp.next=l2;
             l2=l2.next;
         }
        temp=temp.next;
        }
        if(l1==null)
            temp.next=l2;
        else
            temp.next=l1;
    return head.next;
    }




}
