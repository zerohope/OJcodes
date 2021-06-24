package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen {
    static int n;
    static int N=10;
    static  char[][] chess=new char[N][N];
    static  boolean[] col=new boolean[N],dg=new boolean[2*N],udg=new boolean[2*N];
    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder res=new StringBuilder();
    public static void main(String[] args) throws Exception{
        n=Integer.parseInt(reader.readLine());
        for( int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                chess[i][j]='.';
        dfs(0);
    }

    public static void dfs(int u){
        if(u==n){
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    res.append(chess[i][j]);
                }
                res.append("\n");
            }
            System.out.println(res.toString());
            res=new StringBuilder();
            return ;
        }
      for(int i=0;i<n;i++){
          if(!col[i]&&!dg[u+i]&&!udg[u-i+n]){
              col[i]=dg[u+i]=udg[u-i+n]=true;
              chess[u][i]='Q';
              dfs(u+1);
              chess[u][i]='.';
              col[i]=dg[u+i]=udg[u-i+n]=false;
          }
      }
    }
}
