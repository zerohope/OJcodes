package GrokkingDynamicProgramming.Pattern4PalindromicSubsequence;

public class CountOfPalindromicSubstring {
    public int countSubstrings(String s) {
        int rs=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            dp[i][i] = true;
            rs++;
        }
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1||dp[i+1][j-1]){
                        dp[i][j]=true;
                        rs++;
                    }
                }
            }
            return rs;
    }




}
