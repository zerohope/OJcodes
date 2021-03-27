

public class ReverseAlternatingKelementSublist {

    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);
        head.next.next.next.next.next.next.next=new ListNode(8);
        ListNode res=reverse(head,2);
        while(res!=null) {
            System.out.print(res.val + " ");
            res=res.next;
        }

    }

    public static ListNode reverse(ListNode head, int k){
        ListNode previous=null,current=head;
        while(current!=null) {
            ListNode lastNodeOfFirstPart=previous,lastNodeOfSubList=current,next=null;
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (lastNodeOfFirstPart == null)
                head = previous;
            else
                lastNodeOfFirstPart.next = previous;
            lastNodeOfSubList.next = current;
            for (int i = 0; current!=null&&i < k; i++) {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }


}
