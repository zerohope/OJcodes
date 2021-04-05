package leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res=new int[]{0,Integer.MAX_VALUE};
        PriorityQueue<Node> minHeap=new PriorityQueue<>((a,b)->nums.get(a.row).get(a.col)-nums.get(b.row).get(b.col));
        int currentMax=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            minHeap.offer(new Node(i,0));
            currentMax=Math.max(currentMax,nums.get(i).get(0));
        }

        while(minHeap.size()==nums.size()){
            Node cur=minHeap.poll();
            int curSmall=nums.get(cur.row).get(cur.col);
            if(currentMax-curSmall<res[1]-res[0]){
                res[0]=curSmall;
                res[1]=currentMax;
            }
            cur.col++;
            if(cur.col<nums.get(cur.row).size()) {
                currentMax=Math.max(currentMax,nums.get(cur.row).get(cur.col));
                minHeap.offer(cur);
            }
        }
         return res;
    }
}
class Node{
    int row;
    int col;
    Node(int r, int c){
        this.row=r;
        this.col=c;
    }
}