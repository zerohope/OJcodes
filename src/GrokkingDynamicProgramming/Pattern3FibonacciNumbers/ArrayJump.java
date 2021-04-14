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


    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
