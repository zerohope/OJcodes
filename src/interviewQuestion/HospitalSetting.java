package interviewQuestion;

import java.util.Arrays;
import java.util.Scanner;

public class HospitalSetting {
    static int N=110,M=2*N;
    static int[] cnt=new int[N];
    static int idx, h[]=new int[N],e[]=new int[M],ne[]=new int[M];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        idx=0;
        Arrays.fill(h,-1);
        for(int i=1;i<=n;i++){
            cnt[i]=sc.nextInt();
            int l=sc.nextInt(),r=sc.nextInt();
            if(l!=0) {
                add(i, l);
                add(l,i);
            }
            if(r!=0) {
                add(i, r);
                add(r,i);
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            res=Math.min(res,dfs(i,-1,0));
        }
        System.out.println(res);

    }

public static void add(int a,int b){
    e[idx]=b;
    ne[idx]=h[a];
    h[a]=idx++;
}

public static int dfs(int c,int f,int dist){
    int val=cnt[c]*dist;
    for(int i=h[c];i!=-1;i=ne[i]){
        int j=e[i];
        if(j==f)continue;
        val+=dfs(j,c,dist+1);
    }
return val;

}


}
