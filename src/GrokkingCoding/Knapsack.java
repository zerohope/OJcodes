package GrokkingCoding;

public class Knapsack {
    static Integer[][] memory=new Integer[4][8];
    public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex){

        if(currentIndex>=profits.length||capacity<=0)
           return 0;
        if(memory[currentIndex][capacity]!=null)
            return memory[currentIndex][capacity];
        int profit1=0,profit2;
        if(capacity>=weights[currentIndex])
        profit1=profits[currentIndex]+knapsackRecursive(profits,weights,capacity-weights[currentIndex],currentIndex+1);

        profit2=knapsackRecursive(profits,weights,capacity,currentIndex+1);
        memory[currentIndex][capacity]=Math.max(profit1,profit2);
       return memory[currentIndex][capacity];
    }
    public static int dpmethod(int[] profits, int[] weights, int capacity){
        int[][] maxprofits=new int[2][capacity+1];

        for(int j=1;j<=capacity;j++)
            maxprofits[0][j]=1;
        for(int i=1;i<profits.length;i++)
            for (int j=1;j<=capacity;j++){
               int profit1=0,profit2=0;
                if(weights[i]<=j)
                    profit1=profits[i]+maxprofits[(i-1)&1][j-weights[i]];
                 profit2=maxprofits[(i-1)&1][j];
                 maxprofits[i&1][j]=Math.max(profit1,profit2);
            }
        return maxprofits[3&1][7];
    }
public static int dpoptimize(int[] profits, int[] weights, int capacity){
        int[] maxProfits=new int[capacity+1];
        for(int i=0;i<capacity+1;i++)
            if(weights[0]<=i)
            maxProfits[i]=profits[0];

        for(int i=1;i<profits.length;i++)
            for(int j=capacity;j>-1;j--){
                int profit1=0,profit2=0;
                if(weights[i]<=j)
                    profit1=profits[i]+maxProfits[j-weights[i]];
                profit2=maxProfits[j];
                maxProfits[j]=Math.max(profit1,profit2);
            }


    return maxProfits[capacity];
}
    public static void main(String[] args){
        int[] profits={1,6,10,16};
        int[] weights={1,2,3,5};
        System.out.println(dpoptimize(profits,weights,7));

    }
}
