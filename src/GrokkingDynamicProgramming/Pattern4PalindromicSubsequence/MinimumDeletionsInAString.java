package GrokkingDynamicProgramming.Pattern4PalindromicSubsequence;

public class MinimumDeletionsInAString {
    public int minInsertions(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i]=1;
        for(int i=s.length()-2;i>=0;i--)
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }

        return s.length()-dp[0][s.length()-1];
    }


}
