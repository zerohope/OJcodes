package interviewQuestion;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GreenChannel {
    static int N=50010;
    static int n,t;
    static int[] dp=new int[N];
    static int[] w=new int[N];
    static Deque<Integer> q=new LinkedList<>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        t=sc.nextInt();
        for(int i=1;i<=n;i++){
            w[i]=sc.nextInt();
        }
        int left=1,right=n;
        while(left<right){
            int mid=left+right>>1;
            if(check(mid)){
                right=mid;
            }else{
                left=mid+1;
            }

        }
        System.out.println(left-1);
    }

public static boolean check(int key){
        q.clear();
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&q.getFirst()<=i-key)
                q.removeFirst();
            while(!q.isEmpty()&&dp[q.getLast()]>=dp[i])
                q.removeLast();
            q.offer(i);
            dp[i+1]=dp[q.getFirst()]+w[i+1];
        }
        int res=Integer.MAX_VALUE;
        for(int i=n;i>n-key;i--)
            res=Math.min(res,dp[i]);
        return res<=t;
}

}
