package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StouckBuyDP {
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{

        String[] ss = read.readLine().split(" ");
        int N=Integer.valueOf(ss[0]),k=Integer.valueOf(ss[1]);
        int INF = 0x3f3f3f3f;
        int[] stock=new int[N+1];
        ss = read.readLine().split(" ");
        for(int i=1;i<=N;i++)
            stock[i]=Integer.valueOf(ss[i - 1]);
        int[][][] dp=new int[N+1][k+1][2];

        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < k+1; j++){
                dp[i][j][0] = -INF;
                dp[i][j][1] =-INF;
            }
        }
         dp[0][0][0] = 0;
          int res=0;
          for(int i=1;i<N+1;i++)
            for(int j=0;j<k+1;j++){
                dp[i][j][0]=dp[i-1][j][0];
                if(j>0)
                dp[i][j][0]=Math.max(dp[i][j][0],dp[i-1][j-1][1]+stock[i]);
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j][0]-stock[i]);
            }
        for(int i = 0; i <= k; i++) res = Math.max(res, dp[N][i][0]);
        System.out.println(res);
    }







  /*  public static void TLDP(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),k=sc.nextInt();
        int[] stock=new int[N];
                for(int i=0;i<N;i++)
            stock[i]=sc.nextInt();
        int[][] dp=new int[N+1][k+1];
        for(int i=0;i<k+1;i++) {
            dp[0][i] = 0;
            dp[1][i]=0;
        }
        for(int i=1;i<N;i++)
            dp[i][0]=0;
        for(int i=2;i<N+1;i++){
            for(int j=1;j<k+1;j++){
                if(j>i){
                    continue;
                }
              for(int z=1;z<i;z++){
                  if(stock[z-1]<stock[i-1]){
                      dp[i][j]=Math.max(dp[i][j],dp[z-1][j-1]+stock[i-1]-stock[z-1]);
                  }
              }
              dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
            }
        }
        System.out.println(dp[N][k]);
    }*/
}
