package interviewQuestion;

public class DeleteDuplicationList {
  static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteDuplication(ListNode head) {
           if(head==null)
               return head;
            ListNode pre=null,cur=head,next=cur.next;
            while(next!=null){
                if(cur.val!= next.val){
                    pre=cur;
                    cur=next;
                    next=next.next;
                }else{
                    while(next!=null&&next.val==cur.val)
                        next=next.next;
                    if(pre!=null)
                       pre.next=next;
                    else
                        head=next;
                    cur=next;
                    if(next!=null)
                    next=next.next;
                }
            }

            return head;
    }




}
