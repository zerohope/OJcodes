package leetcode;

public class CombinationSumIV377 {
    public int combinationSum4(int[] nums, int target) {
        int len=target;
        int[] dp=new int[target+1];
        dp[0]=1;


            for (int j = 0; j <= target; j++) {
                for (int n : nums) {
                    if (j >= n)
                        dp[j] += dp[j - n];
                }
            }


        return dp[target];
    }




}
