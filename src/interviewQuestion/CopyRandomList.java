package interviewQuestion;


import java.util.HashMap;
import java.util.Map;

class ListNode {
      int val;
      ListNode next, random;
     ListNode(int x) { this.val = x; }
  };

public class CopyRandomList {
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node1.next=node2;
        node2.random=node1;
        copyRandomList(node1);

    }

    //debug出现的问题
    //顾头不顾尾，先把原链表的next指针修改了，之后又想用原链表的next指针
    public static ListNode copyRandomList(ListNode head) {
        ListNode headPoint=head;
        while(headPoint!=null){
            ListNode copy=new ListNode(headPoint.val);
            copy.next=headPoint.next;
            headPoint.next=copy;
            headPoint=copy.next;
        }
        headPoint=head;
        ListNode copyRes=head.next;
        ListNode copyHead=head.next;
        while(headPoint!=null){
            if(headPoint.random!=null)
            headPoint.next.random=headPoint.random.next;
            headPoint=headPoint.next.next;
        }
        headPoint=head;
        while(headPoint!=null) {
            headPoint.next = copyHead.next;
            headPoint = headPoint.next;
            if (headPoint != null) {
                copyHead.next = headPoint.next;
                copyHead = copyHead.next;
            }
        }
    return copyRes;

    }




    //错误的使用了Map
    /*public ListNode copyRandomList(ListNode head) {
        ListNode headPoint=head;
        ListNode copyNode=new ListNode(head.val);
        ListNode copyPoint=copyNode;
        Map<Integer,ListNode> memory=new HashMap<>();
        memory.put(copyPoint.val,copyPoint);
        while(headPoint!=null){
            headPoint=headPoint.next;
            copyPoint.next=new ListNode(headPoint.val);
            copyPoint=copyPoint.next;
            memory.put(copyPoint.val,copyPoint);
        }
        headPoint=head;
        copyPoint=copyNode;
        while(headPoint!=null){
           copyPoint.random=memory.get(headPoint.random.val);
           headPoint=headPoint.next;
           copyPoint=copyPoint.next;
        }

    return copyNode;
    }*/

}
