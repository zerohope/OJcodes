package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecurComEmuII {
    static int N,M;
    static boolean[] check;
    static int[] nums;
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws Exception{
        String[] parm=read.readLine().split(" ");
        N=Integer.valueOf(parm[0]);
        M=Integer.valueOf(parm[1]);
        check=new boolean[N+1];
        nums=new int[N+1];
        parm=read.readLine().split(" ");
        for(int i=1;i<=N;i++)
            nums[i]=Integer.valueOf(parm[i-1]);
        Arrays.sort(nums,1,N+1);
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
                    System.out.print(nums[i]+" ");
            }
            System.out.println();
            return ;
        }
        for(int i=st;i<=N-(M-idx);i++){
            if(i>st&&nums[i]==nums[i-1])
                continue;
            check[i]=true;
            dfs(idx+1,i+1);
            check[i]=false;
        }

    }

}
