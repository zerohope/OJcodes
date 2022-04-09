package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EgyptFraction {
    static List<Integer> ans=new ArrayList<>(),path=new ArrayList<>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int t=1;
        while(true){
            dfs(a,b,1,t);
            if(!ans.isEmpty())
                break;
            t++;
        }
        for(int n:ans) System.out.print(n+" ");
    }
    public static void dfs(long x,long y,int prev,int t){
        long d = gcd(x, y);
        x /= d;
        y /= d;
        if(t==0){
            if(x==0&& (ans.isEmpty()||path.get(path.size()-1)<ans.get(ans.size()-1))){
                ans.clear();
                ans.addAll(path);
            }
            return ;
        }
        int min=Math.max(prev,(int)((y+x-1)/x));
        int max=(int)(y*t/x);
        for(int i=min;i<=max;i++) {
            path.add(i);
            dfs(x * i - y, y * i, i + 1, t - 1);
            path.remove(path.size()-1);
        }
    }
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
