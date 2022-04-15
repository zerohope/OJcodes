package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame1306 {
    boolean[] vistied;
    public boolean canReach(int[] arr, int start) {
        vistied=new boolean[arr.length];
        Queue<Integer> q=new LinkedList<>();
        if(arr[start]==0)
            return true;
        q.offer(start);
        while(!q.isEmpty()){
            int cidx=q.poll();
            if(arr[cidx]==0)
                return true;
            vistied[cidx]=true;
            int nidx=cidx-arr[cidx];
            for(int i=0;i<2;i++) {
                if (nidx >= 0 && nidx < arr.length) {
                    if (!vistied[nidx]) {
                        q.offer(nidx);
                    }
                }
                nidx=cidx+arr[cidx];
            }
        }
    return false;
    }
    
}
