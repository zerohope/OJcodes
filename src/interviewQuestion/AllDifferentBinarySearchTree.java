package interviewQuestion;

import java.util.Scanner;

public class AllDifferentBinarySearchTree {
    static int[] dp;
    static int MOD= 1000000007;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                dp[i]=(int) ((dp[i] + (long) dp[j] * dp[i - j - 1]) % MOD);;

            }
        }
        System.out.println(dp[n]);


    }

}
