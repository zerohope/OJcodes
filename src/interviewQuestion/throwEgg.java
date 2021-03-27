package interviewQuestion;

import java.util.Scanner;

public class throwEgg {
    static final int N=110,M=11;
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int[][] res=new int[M][N];
        for(int i=1;i<=m;i++)
            res[m][1]=i;
        for(int i=1;i<=n;i++)
            res[1][i]=1;
        for(int i=2;i<=m;i++)
            for(int j=2;j<=n;j++){
                res[i][j]=res[i][j-1];
                for(int k=1;k<=j;j++)
                    res[i][j]=Math.min(res[i][j],Math.max(res[k-1][j-1],res[i-k][j])+1);
            }

        System.out.println(res[m][n]);
    }
}
