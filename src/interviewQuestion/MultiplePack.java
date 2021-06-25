package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplePack {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),V=sc.nextInt();
        List<Item> goods=new ArrayList<>();
        int[][][] dp=new int[N+1][V+1][2];
        for(int i=0;i<N;i++){
            Item it=new Item(sc.nextInt(),sc.nextInt(),sc.nextInt());
            goods.add(it);
        }
        for(int i=1;i<=N;i++) {
            Item cur=goods.get(i-1);

            for (int j = 1; j <= V; j++) {
                int ct=cur.count;
                if (j < cur.weight)
                    dp[i][j] = dp[i - 1][j];
                else {
                    ct=ct-dp[i][j-cur.weight][1];
                    if (ct > 0) {
                    int profit1=dp[i-1][j][0],profit2=dp[i][j- cur.weight][0]+cur.val;
                    if(profit2>profit1) {
                        dp[i][j][0] = profit2;
                        dp[i][j][1]=dp[i][j-cur.weight][1]+1;
                    }else
                        dp[i][j][0]=profit1;
                    } else {
                      dp[i][j][0]=dp[i-1][j][0];
                    }
                }
            }
        }
        System.out.println(dp[N][V][0]);

    }



}
class Item{
    int val;
    int weight;
    int count;
  public Item(int v,int w, int c){
      val=w;
      weight=v;
      count=c;
        }

}
