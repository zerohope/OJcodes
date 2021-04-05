package GrokkingCoding;

public class SubsetSum {
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
