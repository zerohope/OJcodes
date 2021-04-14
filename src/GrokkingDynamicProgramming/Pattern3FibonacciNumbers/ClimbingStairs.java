package GrokkingDynamicProgramming.Pattern3FibonacciNumbers;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int temp1=1,temp2=2,res=0;
        for(int i=3;i<=n;i++){
            res=temp1+temp2;
            temp1=temp2;
            temp2=res;
        }
        if(n==0||n==1||n==2)
            return n;
        return res;
    }
}
