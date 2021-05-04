package interviewQuestion;

import java.util.Scanner;

public class TakeTheCoin {
    /*
    * 1.简化问题 只有一种硬币的话，类似斐波那契数列
    * 2.也不是斐波那契数列问题，要去除重复的
    * 3.背包问题
    *
    * */
    final static int N=100010;
    final static int MOD=(int)1e9+7;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt(),n2=sc.nextInt(),m=sc.nextInt();
        int[] f=new int[N];
        f[0]=1;
        for(int i=1;i<=n1;i++){
            int p=sc.nextInt();
            for(int j=p;j<=m;j++){
                f[j]=(f[j]+f[j-p])%MOD;
            }
        }
        for(int i=1;i<=n2;i++){
            int p=sc.nextInt();
            for(int j=m;j>=p;j--)
                    f[j]=(f[j]+f[j-p])%MOD;
        }

        System.out.println(f[m]);
    }


}
