package GrokkingDynamicProgramming.Pattern3FibonacciNumbers;

public class Minimumjumpswithfee {

    public int calFee(int[] fees,int currentIdx){
        if(currentIdx>=fees.length)
            return 0;
        int fee1=calFee(fees,currentIdx+1)+fees[currentIdx];
        int fee2=calFee(fees,currentIdx+2)+fees[currentIdx];
        int fee3=calFee(fees,currentIdx+3)+fees[currentIdx];

        return Math.min(Math.min(fee1,fee2),fee3);
    }
    public int dpSolve(int[] fee){
        int[] dp=new int[fee.length+1];
        dp[1]=dp[2]=dp[3]=fee[0];
        for (int i = 3; i < fee.length; i++)
            dp[i + 1] = Math.min(fee[i] + dp[i], Math.min(fee[i - 1] + dp[i - 1], fee[i - 2] + dp[i - 2]));

    return dp[fee.length];
    }

    public static void main(String[] args) {
        Minimumjumpswithfee sc = new Minimumjumpswithfee();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.calFee(fee,0));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.calFee(fee,0));
    }


}
