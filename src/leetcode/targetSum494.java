package leetcode;

public class targetSum494 {
    //注意nums[0]为0的情况

    public static int findTargetSubsets(int[] nums,int S){
        int sum=0;
        for(int num:nums)
            sum+=num;
        int[][] dp=new int[nums.length][2*sum+1];

        for(int i=0;i<2*sum+1;i++){
            if(nums[0]==Math.abs(i-sum))
                dp[0][i]=1;
        }
        for(int i=1;i<nums.length;i++)
            for(int j=2*sum;j>=0;j--){
                if(j-sum>=sum)
                    dp[i][j]=dp[i-1][j-nums[i]];
                else if(j-sum<=-sum)
                    dp[i][j]=dp[i-1][j+nums[i]];
                else
                    dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]];

            }

        return dp[nums.length-1][2*sum-(sum-S)];
    }

    public static int subSetDp(int[] nums,int S){
        int sum=0;
        for(int num:nums)
            sum+=num;
        int target=sum+S;
        if(sum<S||target%2==1)
            return 0;
        target=target/2;
        int[][] dp=new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++)
            dp[i][0]=1;
        if(nums[0]==0)
            dp[0][0]=2;
        for(int i=1;i<target+1;i++)
          if(i==nums[0])
              dp[0][i]=1;
          else
              dp[0][i]=0;

        for(int i=1;i< nums.length;i++)
            for(int j=0;j<target+1;j++){
                if(nums[i]<=j)
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
                else
                    dp[i][j]=dp[i-1][j];
            }
           return dp[nums.length-1][target];
    }


    public static int dpWithLinerArray(int[] nums,int S){
        int sum=0;
        for(int num:nums)
            sum+=num;
        int target=sum+S;
        if(sum<S||target%2==1)
            return 0;
        target=target/2;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++)
            dp[i]=(nums[0]==i?1:0);
        if(nums[0]==0)
            dp[0]=2;
        for(int i=1;i< nums.length;i++)
          for(int j=target;j>=0;j--){
              if(j>=nums[i])
              dp[j]=dp[j]+dp[j-nums[i]];
          }
     return dp[target];

    }


        public static void main(String[] args){
            System.out.println(dpWithLinerArray(new int[]{1,1,1,1,1},3));
        }

}
