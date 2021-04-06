package GrokkingCoding;

public class CountofSubsetSum {
    public static int countSubsets(int[] num, int sum) {
        int[][] dp = new int[num.length][sum + 1];
        for (int i = 0; i < num.length; i++)
            dp[i][0] = 1;
        for (int i = 1; i < sum + 1; i++) {
            if (num[0] == i)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
    }
        for(int i=1;i<num.length;i++)
            for(int j=1;j<sum+1;j++){
                if(j>=num[i])
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-num[i]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        return dp[num.length-1][sum];
    }
    public static void main(String[] args){
        System.out.println(countSubsets(new int[]{1, 2, 7, 1, 5},9));
    }

}
