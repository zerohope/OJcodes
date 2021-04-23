package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class MinimumDeletionstoMakeaSequenceSorted {
    public void deleteNumbers(int[] nums,int pre,int cur){
        // the same to LongestIncreasingSubsequence
    }
    public int dpSolver(int[] nums){
        int[] dp=new int[nums.length];
        int maxLength=0;
        for(int i=0;i<nums.length;i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
            return maxLength;
    }


}
