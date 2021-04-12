package GrokkingDynamicProgramming.Pattern2UnboundedKnapsack;

import GrokkingCoding.Knapsack;

import java.util.Map;

public class UnboundedKnapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
       int[][] dp=new int[profits.length][capacity+1];
       for(int i=0;i<dp.length;i++)
        dp[i][0]=0;
        for(int i=0;i<dp.length;i++)
            for(int j=1;j<capacity+1;j++){
                int profit1=0,profit2=0;
                if(weights[i]<=j)
                  profit1=profits[i]+dp[i][j-weights[i]];
                if(i>0)
                   profit2=dp[i-1][j];
                dp[i][j]=Math.max(profit1,profit2);
            }
       return dp[profits.length-1][capacity];
    }
   public int knapsackRecursive(Integer[][] dp,int[] profits, int[] weights, int capacity, int currentIndex) {
        if(currentIndex>=profits.length||capacity<=0)
          return 0;
        if(dp[currentIndex][capacity]!=null)
            return dp[currentIndex][capacity];
        int profits1=0,profits2=0;
        if(weights[currentIndex]<=capacity)
         profits1=profits[currentIndex]+knapsackRecursive(dp,profits,weights,capacity-weights[currentIndex],currentIndex);

        profits2=knapsackRecursive(dp,profits,weights,capacity,currentIndex+1);
       dp[currentIndex][capacity] = Math.max(profits1, profits2);
        return dp[currentIndex][capacity];
    }


    public static void main(String[] args) {
        UnboundedKnapsack ks = new UnboundedKnapsack();
        int[] profits = { 15, 20, 50 };
        int[] weights = { 1, 2, 3 };
        int maxProfit = ks.solveKnapsack(profits, weights, 5);
        System.out.println(maxProfit);
    }
}
