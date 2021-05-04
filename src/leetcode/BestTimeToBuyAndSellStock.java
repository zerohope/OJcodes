package leetcode;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    //Best Time to Buy and Sell Stock III
    public int maxProfit(int[] prices) {
        int[] dp=new int[prices.length+1];
        int max=prices[prices.length-1];
        dp[prices.length-1]=0;
        for(int i=prices.length-2;i>-1;i--){
               max=Math.max(max,prices[i+1]);
               if(max>dp[i])
                dp[i]=Math.max(dp[i+1],max-prices[i]);
            else
                dp[i]=dp[i+1];
        }
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
        min=Math.min(min,prices[i-1]);
        if(prices[i]>min){
         res=Math.max(res,prices[i]-min+dp[i+1]);
        }
        }

        return res;
    }




    //Best Time to Buy and Sell Stock II
    public int maxProfit(int[] prices,int cidx, int bidx){
        if(cidx==prices.length)
            return 0;
        if(bidx==-1){
        int c1=maxProfit(prices,cidx+1,cidx);
        int c2=maxProfit(prices,cidx+1,bidx);
        return Math.max(c1,c2);
        }else{
            if(prices[cidx]>prices[bidx]){
                int c1=prices[cidx]-prices[bidx]+maxProfit(prices,cidx+1,-1);
                int c2=maxProfit(prices,cidx+1,bidx);
                return Math.max(c1,c2);
            }else{
                return maxProfit(prices,cidx+1,bidx);
            }
         }

     }
    //Best Time to Buy and Sell Stock II
    public int maxProfitII(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int[] dp=new int[prices.length];
        if(prices[1]>prices[0])
            dp[1]=prices[1]-prices[0];
        int max=0;
        for(int i = 2; i < prices.length; i++) {
            for(int j=0;j<i;j++){
                if(prices[i]>prices[j]){
                    if(j-1>=0)
                    dp[i]=Math.max(dp[i],prices[i]-prices[j]+dp[j-1]);
                    else
                        dp[i]=Math.max(dp[i],prices[i]-prices[j]);
                }
            }
            dp[i]=Math.max(dp[i],dp[i-1]);
            max=Math.max(max,dp[i]);
        }
      return max;
    }


    //Best Time to Buy and Sell Stock I
    public int maxProfitI(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
public static void main(String[] args){
    BestTimeToBuyAndSellStock t=new BestTimeToBuyAndSellStock();
    System.out.println(t.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    Scanner sc=new Scanner(System.in);
    int length=sc.nextInt();
    int[] nbs=new int[length];
    for(int i=0;i<length;i++)
        nbs[i]=sc.nextInt();


}
}
