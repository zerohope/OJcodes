package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RecurComEmu {
    static int N,M;
    static boolean[] check;
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws Exception{
        String[] parm=read.readLine().split(" ");
        N=Integer.valueOf(parm[0]);
        M=Integer.valueOf(parm[1]);
        check=new boolean[N+1];
        if(M==0) {
            System.out.println(" ");
        }else {
            dfs(1, 1);
        }
    }
    public static void dfs(int idx,int st){
        if(idx==M+1){
            for (int i = 1; i <= N; i++) {
                if (check[i])
                    System.out.print(i+" ");
            }
            System.out.println();
        }
        for(int i=st;i<=N;i++){
            check[i]=true;
            dfs(idx+1,i+1);
            check[i]=false;
        }

    }

}
