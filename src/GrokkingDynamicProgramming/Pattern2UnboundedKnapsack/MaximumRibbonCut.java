package GrokkingDynamicProgramming.Pattern2UnboundedKnapsack;

public class MaximumRibbonCut {
    public int countRibbonPieces(int[] ribbonLengths, int total) {
        int[][] dp=new int[ribbonLengths.length][total+1];
        for(int i=0;i<ribbonLengths.length;i++)
            for(int j=0;j<total+1;j++)
                dp[i][j]=Integer.MIN_VALUE;
        for(int i=0; i < ribbonLengths.length; i++)
            dp[i][0] = 0;
         for(int i=0;i<ribbonLengths.length;i++)
             for(int j=1;j<total+1;j++){
                 if(i>0)
                     dp[i][j]=dp[i-1][j];
                 if(j>=ribbonLengths[i]&&dp[i][j-ribbonLengths[i]]!=Integer.MIN_VALUE)
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-ribbonLengths[i]]+1);
             }
         return dp[ribbonLengths.length-1][total]==Integer.MIN_VALUE?-1:dp[ribbonLengths.length-1][total];
    }

    public static void main(String[] args) {
        MaximumRibbonCut cr = new MaximumRibbonCut();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{5,3,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
