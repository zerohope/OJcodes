package interviewQuestion;

import java.util.Scanner;

public class BuildRestaurant {
    static int[] places=new int[100];
    static int[] value=new int[100];
    static int[] dp=new int[100];
    public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int T=sc.nextInt();
         while(T>0){
             int n=sc.nextInt();
             int k=sc.nextInt();
             for(int i=0;i<n;i++){
                 places[i]=sc.nextInt();
             }
             for(int i=0;i<n;i++){
                 value[i]=sc.nextInt();
             }
             dp[0]=value[0];
             for(int i=1;i<n;i++){
                 int j=i-1;
                 while(j>-1&&places[i]-places[j]<=k) j--;
                 if(j==-1){
                     dp[i]=Math.max(dp[i-1],value[i]);
                 }else{
                     dp[i]=Math.max(dp[i-1],dp[j]+value[i]);
                 }
             }
             System.out.println(dp[n-1]);

             T--;
         }

    }


}
