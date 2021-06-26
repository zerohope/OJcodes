package interviewQuestion;

import java.util.Scanner;

public class Skiing {
    static  int[][] dp;
    static int[][] arr;
    static int R,C;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();C=sc.nextInt();
        arr=new int[R+2][C+2];
        dp=new int[R+2][C+2];
        int res=0;
        for(int i=1;i<=R;i++)
            for(int j=1;j<=C;j++)
                arr[i][j]=sc.nextInt();
        for(int i=0;i<R;i++){
            arr[i][0]=10010;
            arr[i][C+1]=10010;
        }
        for(int i=0;i<C;i++){
            arr[0][i]=10010;
            arr[R+1][i]=10010;
        }

        for(int i=1;i<=R;i++)
            for(int j=1;j<=C;j++){
             res=Math.max(res,dp(i,j));
            }



        System.out.println(res);
    }

static int dp(int x,int y){

        if(dp[x][y]!=0) return dp[x][y];
        int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{-1,1,0,0};
    dp[x][y]=1;
    for(int i=0;i<4;i++){
        int xi=x+dx[i],yi=y+dy[i];
        if(xi>=1&&xi<=R&&yi>=1&&yi<=C&&arr[x][y]>arr[x+dx[i]][y+dy[i]])
            dp[x][y]=Math.max(dp[x][y],dp(x+dx[i],y+dy[i])+1);
    }
  return dp[x][y];
}

}
