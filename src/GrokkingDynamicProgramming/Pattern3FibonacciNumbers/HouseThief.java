package GrokkingDynamicProgramming.Pattern3FibonacciNumbers;

public class HouseThief {
    public int findMaxSteal(int[] wealth) {
        return findMaxStealRecursive(wealth, 0);
    }
    public int findMaxStealRecursive(int[] wealth,int idx){
        if(idx>=wealth.length)
            return 0;
        int steal1=findMaxStealRecursive(wealth,idx+2)+wealth[idx];
        int steal2=findMaxStealRecursive(wealth,idx+1);

       return Math.max(steal1,steal2);
    }
    public int dpSolver(int[] wealth){
        int[] dp=new int[wealth.length];
        if(wealth.length == 0) return 0;
        int temp1=0,temp2=wealth[0],rs=0;
        for(int i=1;i<wealth.length;i++){
            rs=Math.max(temp2,temp1+wealth[i]);
            temp1=temp2;
            temp2=rs;
        }
        return rs;
    }
    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.dpSolver(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.dpSolver(wealth));
    }

}
