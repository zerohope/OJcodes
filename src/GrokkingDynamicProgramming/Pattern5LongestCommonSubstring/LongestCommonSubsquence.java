package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class LongestCommonSubsquence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=text1.length()-1;i>=0;i--){
            if(text1.charAt(i)==text2.charAt(text2.length()-1)) {
                while(i>=0)
                    dp[i--][text2.length() - 1] = 1;
            }
        }
        for(int i=text2.length()-1;i>=0;i--){
            if(text2.charAt(i)==text1.charAt(text1.length()-1))
                while(i>=0)
                    dp[text1.length()-1][i--]=1;
        }
        for(int i=text1.length()-2;i>=0;i--)
            for(int j=text2.length()-2;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j))
                    dp[i][j]=Math.max(dp[i+1][j+1]+1,Math.max(dp[i+1][j],dp[i][j+1]));
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        return dp[0][0];
    }
    public int findLongestSubstring(String text1,String text2,int i, int j){
        if(i==text1.length()||j==text2.length())
            return 0;

        if(text1.charAt(i)==text2.charAt(j))
            return 1+findLongestSubstring(text1,text2,i+1,j+1);

        int temp1=findLongestSubstring(text1,text2,i+1,j);
        int temp2=findLongestSubstring(text1,text2,i,j+1);

        return Math.max(temp1,temp2);
    }

    public static void main(String[] args) {
        LongestCommonSubsquence lcs = new LongestCommonSubsquence();
        System.out.println(lcs.longestCommonSubsequence("ezupkr", "ubmrapg"));

    }


}
