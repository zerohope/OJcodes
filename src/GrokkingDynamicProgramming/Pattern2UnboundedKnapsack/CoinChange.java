package GrokkingDynamicProgramming.Pattern2UnboundedKnapsack;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            dp[i][0]=1;
        for(int i=0;i<coins.length;i++)
            for(int j=1;j<amount+1;j++){
                int nums1=0,nums2=0;
                if(j>=coins[i])
                nums1=dp[i][j-coins[i]];
                if(i>0)
                nums2=dp[i-1][j];
                dp[i][j]=nums1+nums2;
        }
        return dp[coins.length-1][amount];
    }
    public int coinChange2(int[] coins,int amount){
        if(coins.length==0||amount==0)
            return 0;
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            for(int j=1;j<amount+1;j++){
                int nums1=0,nums2=0;
                if(j>=coins[i])
                    nums1=dp[i][j-coins[i]]+1;
                if(i>0)
                    nums2=dp[i-1][j];
                if(nums1==0||nums2==0)
                    dp[i][j]=nums1+nums2;
                else
                    dp[i][j]=Math.min(nums1,nums2);
            }

        return dp[coins.length-1][amount]==0?-1:dp[coins.length-1][amount];


    }
    public static void main(String[] args){



    }
}
