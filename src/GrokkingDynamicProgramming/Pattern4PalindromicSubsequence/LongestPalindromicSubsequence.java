package GrokkingDynamicProgramming.Pattern4PalindromicSubsequence;

public class LongestPalindromicSubsequence {
    public int palindromicSub(String s,int left, int right){
        if(left>right)
            return 0;
        if(left==right)
            return 1;
        if(s.charAt(left)==s.charAt(right))
            return palindromicSub(s,left+1,right-1)+2;
        int temp1=palindromicSub(s,left+1,right);
        int temp2=palindromicSub(s,left,right-1);
        return Math.max(temp1,temp2);
    }
    public int dpSolver(String s){
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

        return dp[0][s.length()-1];
    }
    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.dpSolver("abdbca"));
        System.out.println(lps.dpSolver("cddpd"));
        System.out.println(lps.dpSolver("pqr"));
    }
}
