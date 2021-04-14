package GrokkingDynamicProgramming.Pattern3FibonacciNumbers;

public class ArrayJump {
    public int countMinJumps(int[] jumps) {
        int[] memory=new int[jumps.length];
        return this.countMinJumpsRecursive(memory,jumps, 0);
    }
   public int countMinJumpsRecursive(int[] memory, int[] jump, int idx){
       if(jump[idx]==0)
           return Integer.MAX_VALUE;
       if(idx==jump.length-1)
         return 0;
       if(memory[idx]!=0)
        return memory[idx];
       int start=idx+1,end=idx+jump[idx];
       int totalCount=Integer.MAX_VALUE;
       for(int i=start;i<=end&&i<jump.length;i++){
           int minStep=countMinJumpsRecursive(memory,jump,i);
           if(minStep!=Integer.MAX_VALUE)
           totalCount=Math.min(minStep+1,totalCount);
       }
       memory[idx]=totalCount;
       return totalCount;
   }
  public int dpSolve(int[] jumps){
        int[] dp=new int[jumps.length];
      /*  for(int i=jumps.length-2;i>=0;i--){
            int st=i+1,ed=i+jumps[i];
            int temp=Integer.MAX_VALUE;
            while(st<=ed&&st< jumps.length){
                temp=Math.min(temp,dp[st++]);
            }
            if(temp!=Integer.MAX_VALUE)
                dp[i]=temp+1;
            else
                dp[i]=temp;
        }*/
        for(int i=1;i<jumps.length;i++)
            dp[i]=Integer.MAX_VALUE;
        for(int i=0;i<jumps.length;i++){
            int start=i+1, ed=i+jumps[i];
            while(start<=ed&&start<jumps.length) {
                dp[start] = Math.min(dp[start], dp[i] + 1);
                start++;
            }
        }

        return dp[jumps.length-1];
  }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.dpSolve(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.dpSolve(jumps));
    }
}
