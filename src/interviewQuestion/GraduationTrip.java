package interviewQuestion;

import java.util.Arrays;
import java.util.Scanner;

public class GraduationTrip {
    static int N=20;
    static int[][] w=new int[N][N],dp=new int[1<<N][N];

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                w[i][j]=sc.nextInt();
        for(int i=0;i<1<<N;i++){
            //对整行赋值
            Arrays.fill(dp[i],(int)1e9);
        }
        dp[1][0]=0;
      for(int i=1;i<1<<n;i+=2){
          for(int j=0;j<n;j++){
            if((i>>j&1)>0){
                for(int k=0;k<n;k++){
                    if((i-(1<<j)>>k&1)>0){
                        dp[i][j]=Math.min(dp[i][j],dp[i-(1<<j)][k]+w[k][j]);
                    }

                }
            }
          }
      }
        int res=Integer.MAX_VALUE;
       for(int i=1;i<n;i++){
           res=Math.min(res,dp[(1<<n)-1][i]+w[i][0]);
       }
        System.out.println(res);

    }

}
