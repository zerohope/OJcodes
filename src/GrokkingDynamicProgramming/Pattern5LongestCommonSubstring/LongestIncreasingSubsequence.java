package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class LongestIncreasingSubsequence {

    public int Lis(int[] nums,int idx,int flag){
        if(idx>=nums.length)
            return 0;
        int temp1=0,temp2=0,temp3=0;
        if(nums[idx]>flag){
            temp1=1+Lis(nums,idx+1,nums[idx]);
        }
        temp2=Lis(nums,idx+1,nums[idx]);
        //未考虑
        temp3=Lis(nums,idx+1,flag);
        return Math.max(temp1,Math.max(temp2,temp3));
    }
    //教程用currentIndex和previousIndex，把两种情况合并
    private int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex>=nums.length)
            return 0;
        int c1=0,c2=0;
        if(previousIndex==-1||nums[currentIndex]>nums[previousIndex])
            c1=1+findLISLengthRecursive(nums,currentIndex+1,currentIndex);
        c2=findLISLengthRecursive(nums,currentIndex+1,previousIndex);
        return Math.max(c1,c2);
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int maxLength=0;
        for(int i=0;i<nums.length;i++)
            dp[i]=1;
        for(int i=1;i<nums.length;i++)
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxLength=Math.max(maxLength,dp[i]);
            }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lis.lengthOfLIS(nums));

    }

}
