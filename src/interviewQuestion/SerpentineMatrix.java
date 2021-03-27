package interviewQuestion;

import java.util.Scanner;

public class SerpentineMatrix {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] dx=new int[]{1,0,-1,0};
        int[] dy=new int[]{0,1,0,-1};
        int a=sc.nextInt(),b=sc.nextInt();
        int[][] res=new int[a][b];
        for(int k=1,x=0,y=0,d=0;k<=a*b;k++){
            res[x][y]=k;
            int cx=x+dy[d],cy=y+dx[d];
            if(cx>=a||cx<0||cy>=b||cy<0||res[cx][cy]!=0){
                d=(d+1)%4;
                cx=x+dy[d];
                cy=y+dx[d];
            }
            x=cx;
            y=cy;
        }
        for(int s=0;s<a;s++){
            for(int t=0;t<b;t++)
                System.out.print(res[s][t]+" ");
            System.out.println("");
        }
    }

}
