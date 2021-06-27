package interviewQuestion;

import java.util.Scanner;

public class RobotJump {
    static int N=100000;
    static int n;
    static int[] h=new int[N];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++)
           h[i]=sc.nextInt();
        int st=0,end=N;

        while(st<end){
         int mid=(st+end)/2;
         if(check(mid)==1){
            end=mid;
         }else{
             st=mid+1;
         }

        }
        System.out.println(end);
    }
    public static int check(int e){
        for(int i=0;i<n;i++){
            e=2*e-h[i];
            if(e>N){
                return 1;
            }
            if(e<0)
                return 0;
        }
        return 1;

    }

}
