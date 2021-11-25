package interviewQuestion;

import java.util.Arrays;
import java.util.Scanner;

public class CutRope {
    //存在问题:怎么跳出循环？
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),M=sc.nextInt();
        int[] ropes=new int[N];
        for(int i=0;i<N;i++)
            ropes[i]=sc.nextInt();
        Arrays.sort(ropes);
        if(M<N)
            System.out.println(ropes[M-1]);
        else{
            double left=0,right=1e9;
            while(right-left>1e-4){
                double mid=(left+right)/2;
                int count=0;
                for(int i=0;i<N;i++){
                    count+=ropes[i]/mid;
                    if(count>=M){
                        break;
                    }
                }
                if(count>=M){
                    left=mid;
                }else{
                    right=mid;
                }
            }
            //输出浮点数
            System.out.printf("%.2f",left);

        }
    }



}
