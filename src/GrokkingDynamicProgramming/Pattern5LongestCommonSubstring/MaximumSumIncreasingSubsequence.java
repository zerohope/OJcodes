package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class MaximumSumIncreasingSubsequence {
    public int calMaxVal(int[] nums,int cidx,int pidx){
            if(cidx>=nums.length)
                return 0;
            int c1=0,c2=0;
            if(pidx==-1||nums[cidx]>nums[pidx]){
                c1=nums[cidx]+calMaxVal(nums,cidx+1,cidx);
            }
            c2=calMaxVal(nums,cidx+1,pidx);
      return Math.max(c1,c2);
    }
    public int dpSolver(int[] nums){
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            dp[i]=nums[i];
        int maxVal=0;
        for(int i=1;i<nums.length;i++)
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+nums[i]);
                maxVal=Math.max(dp[i],maxVal);
            }
        return maxVal;
    }



}
