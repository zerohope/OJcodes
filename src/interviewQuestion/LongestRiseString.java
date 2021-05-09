package interviewQuestion;

import java.util.Scanner;

public class LongestRiseString {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        int st=0,skip=1,maxLength=0,nst=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                if(skip==0)
                maxLength=Math.max(maxLength,i-st-1);
                else
                    maxLength=Math.max(maxLength,i-st);
            }else{
                if(skip==1) {
                    skip--;
                    nst=i;
                    continue;
                }else{
                    skip=1;
                    st=nst;
                }
            }
        }
        System.out.println(maxLength);
    }

}
