package leetcode;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
    public static int[][] kClosest(int[][] points, int k) {
        int[][] res=new int[k][2];
        if(k==0)
            return res;
        PriorityQueue<Integer> q=new PriorityQueue<>((n1, n2)->points[n2][0]*points[n2][0]+points[n2][1]*points[n2][1]
                -points[n1][0]*points[n1][0]-points[n1][1]*points[n1][1]);

        for(int i=0;i<k;i++){
            q.offer(i);
        }
        for(int i=k;i<points.length;i++){
            double temp=Math.pow(points[i][0],2)+Math.pow(points[i][1],2);
            double smallMax=Math.pow(points[q.peek()][0],2)+Math.pow(points[q.peek()][1],2);
            if(smallMax>temp){
                q.poll();
                q.offer(i);
            }
        }
        for(int i=0;i<k;i++)
            res[i]=points[q.poll()];
        return res;
    }

    public static void main(String[] args){

        kClosest(new int[][]{new int[]{1,3},new int[]{-2,2},new int[]{2,-2}},2);




    }
}
