package leetcode;

import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
     ListNode res=new ListNode();
     ListNode head=res;
     PriorityQueue<ListNode> minHeap=new PriorityQueue<>((n1,n2)->n1.val-n2.val);
     for(ListNode node:lists) {
         if(node!=null)
         minHeap.offer(node);
     }
    while(!minHeap.isEmpty()){
        ListNode cur=minHeap.poll();
        res.next=cur;
        if(minHeap.isEmpty())
            break;
        res=res.next;
        if(cur.next!=null)
        minHeap.offer(cur.next);
    }
    return head.next;
    }


}

  class ListNode {
     int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
