package interviewQuestion;

import java.util.Scanner;

public class StouckBuyRC {
    static Integer[][][] dp;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),k=sc.nextInt();
        int[] stock=new int[N];
        dp=new Integer[N][N][k+1];
        for(int i=0;i<N;i++)
          stock[i]=sc.nextInt();
        System.out.println(operation(stock,0,N-1,k));

    }
    public static int operation(int[] stock,int st,int ed, int k){
        if(dp[st][ed][k]!=null)
            return dp[st][ed][k];
        if(k==0) {
            dp[st][ed][k]=0;
            return 0;
        }
        int res=0;
        int min=stock[st];
        for(int i=st+1;i<ed;i++){
            if(stock[i]>min){
                res=Math.max(res,stock[i]-min+operation(stock,i,ed,k-1));
            }
            min=Math.min(min,stock[i]);
        }
        dp[st][ed][k]=res;
        return res;
    }



}
