package interviewQuestion;

import java.util.Scanner;

public class MaxSum {
    static int[] arr=new int[50001];
    static int[] dp1=new int[50001];
    static int[] dp2=new int[50001];
    static int[] max1=new int[50001];
    static int[] max2=new int[50001];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T>0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            dp1[n-1]=arr[n-1];
            for(int i=n-2;i>-1;i--){
                dp1[i]=Math.max(arr[i],arr[i]+dp1[i+1]);
            }
            dp2[0]=arr[0];
            for(int i=1;i<n;i++){
                dp2[i]=Math.max(arr[i],arr[i]+dp2[i-1]);
            }
            int res=Integer.MIN_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
            max=Math.max(max,dp2[i]);
            max2[i]=max;
            }
            max=Integer.MIN_VALUE;
            for(int i=n-1;i>-1;i--){
                max=Math.max(max,dp1[i]);
                max1[i]=max;
            }
           for(int i=0;i<n-1;i++)
              res=Math.max(res,max2[i]+max1[i+1]);
            System.out.println(res);
            T--;
        }


    }


    //超时
  /*  public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T>0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
         dp1[n-1]=arr[n-1];
        for(int i=n-2;i>-1;i--){
            dp1[i]=Math.max(arr[i],arr[i]+dp1[i+1]);
        }
        dp2[0]=arr[0];
        for(int i=1;i<n;i++){
            dp2[i]=Math.max(arr[i],arr[i]+dp2[i-1]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
          for(int j=i+1;j<n;j++){
              res=Math.max(res,dp2[i]+dp1[j]);
          }
        }
            System.out.println(res);


        T--;
        }


    }

*/


}
