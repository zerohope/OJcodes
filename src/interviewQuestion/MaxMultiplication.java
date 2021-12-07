package interviewQuestion;

import java.util.Scanner;

public class MaxMultiplication {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),K=sc.nextInt();
        char[] digits=sc.next().toCharArray();
        System.out.println(MaxMulti(digits,0,N-1,K));


    }
    public static int MaxMulti(char[] digits,int st,int ed,int k){
        if(ed-st<k){
            return 0;
        }
        if(k==0)
            return buildNb(digits,st,ed);
        int temp=0;
        for(int i=st;i<=ed-k;i++){
            temp=Math.max(temp,buildNb(digits,st,i)*MaxMulti(digits,i+1,ed,k-1));
        }
        return temp;

    }
    public static int buildNb(char[] digits,int st,int ed){
        int res=digits[st]-'0';
        for(int i=st+1;i<=ed;i++)
            res=res*10+(digits[i]-'0');
    return res;
    }

}
