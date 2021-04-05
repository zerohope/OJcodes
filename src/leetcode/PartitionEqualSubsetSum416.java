package leetcode;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums)
            sum+=num;
        if(sum%2!=0)
            return false;

        return findSubsets(nums,0,sum/2);
    }
    public boolean findSubsets(int[] nums, int currentIdx,int sum){
        if(sum==0)
          return true;
        if(nums.length==0||currentIdx>=nums.length)
          return false;
        if(nums[currentIdx]<=sum)
          if(findSubsets(nums,currentIdx+1,sum-nums[currentIdx]))
              return true;

        return findSubsets(nums,currentIdx+1,sum);
    }

    public boolean dpmethod(int[] nums, int sum,int currentIdx){
       Boolean[][] dp=new Boolean[nums.length][sum+1];
       for(int i=0;i<nums.length;i++)
          dp[i][0]=true;
       for(int i=1;i<sum+1;i++) {
           if (nums[currentIdx] == i)
               dp[0][i] = true;
           else
               dp[0][i]=false;
       }

       for(int i=1;i<nums.length;i++)
           for(int j=1;j<sum+1;j++){
              if(nums[i]<=j){
                   dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
               }else {
                   dp[i][j] = dp[i - 1][j];
               }

           }
        return dp[nums.length-1][sum];
    }


}
