package leetcode;

import java.util.Arrays;

public class JumpGame1340 {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        int res=0;
        for(int i=0;i<arr.length;i++){
           res=Math.max(res,dfs(i,arr,d));
        }
        return res;
    }
    public int dfs(int idx,int[] arr, int d){
        if(dp[idx]!=-1)
            return dp[idx];
        int l=Math.max(idx-d,0);
        int r=Math.min(idx+d,arr.length-1);
        int max=0;
        for(int dirction=-1;dirction<=1;dirction+=2){
           for(int i=idx+dirction;i<=r&&i>=l;i+=dirction){
               if(arr[i]>=arr[idx])
                   break;
               max=Math.max(max,dfs(i,arr,d));
           }
        }
        if(dp[idx]==-1)
        dp[idx]=max+1;
        return dp[idx];
    }

    public int maxJumps1(int[] arr, int d) {
      //dp solve
        return 0;
    }



}
