package interviewQuestion;

import java.util.Scanner;

public class MaxSquare {
    static int n,m;
    static int N=1000,M=1000;
    static int[][] arr=new int[N][M];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();m=sc.nextInt();
        int res=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
             arr[i][j]=sc.nextInt();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
            if(arr[i][0]==1)
             dp[i][0]=1;
        for(int i=0;i<m;i++)
            if(arr[0][i]==1)
            dp[0][i]=1;
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++){
                if(arr[i][j]==0)
                    continue;
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                res=Math.max(res,dp[i][j]);
            }
        System.out.println(res*res);
    }




}
