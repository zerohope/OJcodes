public class reverseKGroup25 {

    public static void main(String[] args){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        reverseKGroup(n1,3);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode re=new ListNode();
        ListNode pre=new ListNode();
        ListNode pos=new ListNode();
        int length=countSize(head);
        int lt=length/k;
        for(int i=0;i<lt;i++){
            for(int j=0;j<k-1;j++){
                pre=head;
                pos=head.next;
                pre.next=pos.next;
                pos.next=pre;
                head=pre.next;
            }
            if(head.next!=null)
             pre.next=head.next;
            if(i==0)
                re=pos;
        }
        return re;
    }

    public static int countSize(ListNode head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }


}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }