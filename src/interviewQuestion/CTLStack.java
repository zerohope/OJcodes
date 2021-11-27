package interviewQuestion;

import java.util.Scanner;

public class CTLStack {
   static long[][] dp=new long[40][40];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            for(int j=1;j<i;j++)
            {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        System.out.println(dp[2*n][n]/(n+1));



    }



}
