package Euler;

public class LatticePaths_15 {
    public static void main(String[] args){
            long[][] d[22][22];
            dp[0][0]=1;
            for(int i=1;i<22;i++){
                dp[0][i]=dp[0][i-1];
                dp[i][0]=dp[i-1][0];
            }
            for(int i=1;i<22;i++)
                for(int j=1;j<22;j++){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
        System.out.println(dp[20][20]);
    }


}
