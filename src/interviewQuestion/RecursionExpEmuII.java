package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursionExpEmuII {
    static int N=15;
    static int[] nums=new int[N];
    static boolean[] check=new boolean[N];
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws Exception{
      N=Integer.valueOf(read.readLine());

      String[] nbs=read.readLine().split(" ");
      for(int i=0;i<N;i++)
        nums[i]=Integer.valueOf(nbs[i]);
        Arrays.sort(nums,0,N);
        dfs(0);
    }
    public static void dfs(int idx){
        if(idx>N-1){
            for(int i=0;i<N;i++){
                if(check[i])
                System.out.print(nums[i]+" ");
            }
            System.out.println(" ");
        return ;
        }
        if(idx>0&&nums[idx]==nums[idx-1]&&check[idx-1]){
            check[idx]=true;
            dfs(idx+1);
        }else {
            check[idx] = false;
            dfs(idx + 1);
            check[idx] = true;
            dfs(idx + 1);

        }
    }


}
