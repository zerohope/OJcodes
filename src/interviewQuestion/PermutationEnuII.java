package interviewQuestion;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationEnuII {
    static int N=10;
    static int[] res=new int[N];
    static boolean[] visit=new boolean[N];
    static int[] nums;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        nums=new int[N];
        for(int i=0;i<N;i++)
            nums[i]=sc.nextInt();
        Arrays.sort(nums,0,N);
        dfs(0);
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }

    public static void dfs(int idx){
        if(idx==N)
            return ;
        for(int i=0;i<N;i++){
            if(res[idx]==nums[i])
                continue;

            if(!visit[i]){
                visit[i]=true;
                res[idx]=nums[i];
                dfs(idx+1);
                visit[i]=false;
            }
        }
        if(idx==N-1){
            for(int i=0;i<N;i++) {
                sb.append(res[i] + " ");
            }
           sb.append("\n");
        }
        res[idx]=0;
    }



}
