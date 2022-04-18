package leetcode;

import java.util.LinkedList;

public class JumpGame1696 {
    public static void main(String[] args){

        maxResult(new int[]{10,-5,-2,4,0,3},3);


    }


    public static int maxResult(int[] arr, int k) {
        LinkedList<Integer> q=new LinkedList<>();
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        for( int i=1;i<arr.length;i++){
            while (!q.isEmpty()&&dp[q.peekLast()]<dp[i-1])
                    q.removeLast();
            q.offerLast(i-1);
            if(q.peekFirst()<i-k)
            q.removeFirst();
            dp[i]=dp[q.peekFirst()]+arr[i];
        }
        return dp[arr.length-1];
    }


}
