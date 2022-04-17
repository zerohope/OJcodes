package GrokkingDynamicProgramming.Pattern4PalindromicSubsequence;

import java.util.Arrays;

public class CountOfPalindromicSubstring {
    int[][] dp;
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
    public int answer(String s){
        dp=new int[s.length()][s.length()];
       //Arrays.fill(dp,-1);
        return dfs(s,0,s.length()-1);
    }
    public int dfs(String s,int i,int j){
        if(dp[i][j]!=-1)
            return 0;
        if(i>j)
             return 0;
        if(i==j)
            return 1;
       int cur=check(s,i,j);
       int res=dp[i][j-1]+dp[i-1][j]+cur;
       dp[i][j]=res;
        return dp[i][j];
    }
    public int check(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;j--;
            }else{
                return 0;
            }
        }
        return 1;

    }

}
