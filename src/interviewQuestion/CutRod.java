package interviewQuestion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
* Debug
* 判断条件边界，缺等号
* 数组忘排序
*数组下标直接用
*
* */
public class CutRod {
    static int[] nums;
    static boolean[] visited;
    static int sum;
    static int n;
    static int length;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        while(n!=0){
            nums=new int[n];
            visited=new boolean[n];
            int max=Integer.MIN_VALUE;
            sum=0;
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
                sum+=nums[i];
                max=Math.max(max,nums[i]);

            }
            length=max;

            sort(nums, n);
          while(true){
              if(sum%length==0&&dfs(0,0,0)){
                  System.out.println(length);
                    break;
              }
              length++;
          }
            n=sc.nextInt();
        }

    }
    public static boolean dfs(int u,int cur,int idx){
        if(u*length==sum){
            return true;
        }
        if(cur==length) return dfs(u+1,0,0);
        for(int i=idx;i<n;i++){
            if(visited[i]) continue;
            int l=nums[i];
            if(cur+l<=length){
                visited[i]=true;
                if(dfs(u,cur+l,idx+1)) return true;
                visited[i]=false;
            }
        if(cur==0||cur==length-l) return false;
        int j=i+1;
        while(j<n&&nums[j]==l) j++;
        i=j-1;

        }
        return false;

    }

    private static void sort(int[] a, int n){
        Arrays.sort(a, 0, n);
        int l = 0; int r = n - 1;
        while (l < r){
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l ++;
            r --;
        }
    }
}
