package interviewQuestion;

import java.util.*;

public class RoundTableSeating {

public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    boolean[][] friends=new boolean[n+1][n+1];
    boolean[] visit=new boolean[n+1];
    for(int i=1;i<m+1;i++){
        int a=sc.nextInt();
        int b=sc.nextInt();
        friends[a][b]=true;
        friends[b][a]=true;
    }
    System.out.println(countSum(1,1,friends,visit,n));
}
public static int countSum(int level,int num,boolean[][] friends, boolean[] visit,int n){
    if(level==n){
        if(friends[num][1]) return 0;
        return 1;
    }
    int sum=0;
    for(int i=2;i<n+1;i++){
        if(!friends[num][i]&&!visit[i]){
            visit[i]=true;
            sum+=countSum(level+1,i,friends,visit,n);
            visit[i]=false;
        }
    }
  return sum;
}




}
