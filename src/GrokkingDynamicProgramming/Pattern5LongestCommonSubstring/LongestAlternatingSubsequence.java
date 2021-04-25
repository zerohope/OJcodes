package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class LongestAlternatingSubsequence {
    public int findLASLength(int[] nums) {
        // we have to start with two recursive calls, one where we will consider that the first element is
        // bigger than the second element and one where the first element is smaller than the second element
        return Math.max(findLASLengthRecursive(nums, -1, 0, true),
                findLASLengthRecursive(nums, -1, 0, false));
    }


    //有情况判断不全
    public int findLASLength(int[] nums,int pre,int cur){
        if(cur==nums.length-1&&pre!=-1)
          return 1;
        if(cur==nums.length&&pre==-1)
            return 0;
        int c1=0,c2=0;
        if(pre==-1||nums[cur]<nums[pre]&&nums[cur]<nums[cur+1]||nums[cur]>nums[pre]&&nums[cur]>nums[cur+1])
             c1=1+findLASLength(nums,cur,cur+1);
        c2=findLASLength(nums,pre,cur+1);
        return Math.max(c1,c2);
    }

    public int findLASLengthRecursive(int[] nums,int pre,int cur,boolean isAsc){
        if(cur==nums.length)
          return 0;
        int c1=0,c2=0;
        if(isAsc){
            if(pre==-1||nums[cur]>nums[pre])
                c1=1+findLASLengthRecursive(nums,cur,cur+1,!isAsc);
        }else{
            if(pre==-1||nums[cur]<nums[pre])
                c1=1+findLASLengthRecursive(nums,cur,cur+1,!isAsc);
        }
        c2=findLASLengthRecursive(nums,pre,cur+1,isAsc);
        return Math.max(c1,c2);
    }
    public int dpSolver(int[] nums){
        int[][] dp=new int[nums.length][2];
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<2;j++){
                dp[i][j]=1;
            }
        int maxLength=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i][0]=Math.max(dp[j][1]+1,dp[i][0]);
                }
                if(nums[i]<nums[j])
                    dp[i][1]=Math.max(dp[j][0]+1,dp[i][1]);
            }
            maxLength=Math.max(maxLength,Math.max(dp[i][0],dp[i][1]));
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestAlternatingSubsequence las = new LongestAlternatingSubsequence();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums,-1,0));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums,-1,0));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums,-1,0));
    }

}
