package GrokkingCoding;

public class MinimumSubsetSumDifference {
   public int canPartition(int[] num){
       int sum=0;
       for(int n:num)
           sum+=n;
       int[][] dp=new int[num.length][sum+1];

       for(int i=0;i<num.length;i++)
           dp[i][0]=sum;
       for(int i=0;i<sum+1;i++) {
           if (i == num[0])
               dp[0][i] =sum-i;
           else
               dp[0][i]=sum;
       }
        for(int i=1;i<num.length;i++)
            for(int j=0;j<sum+1;j++){
                if(num[i]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-num[i]]);
                }else
                    dp[i][j]=dp[i-1][j];
            }
      return dp[num.length-1][sum];
   }


}
