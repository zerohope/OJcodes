package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class ShortestCommonSequence {
    public int findSCSLengthRecursive(String s1,String s2,int i1,int i2){
        if(i1==s1.length())
          return s2.length()-i2;
        if(i2==s2.length())
            return s1.length()-i1;
        if(s1.charAt(i1)==s2.charAt(i2))
            return 1+findSCSLengthRecursive(s1,s2,i1+1,i2+1);
        int length1 = 1 + findSCSLengthRecursive(s1, s2, i1, i2+1);
        int length2 = 1 + findSCSLengthRecursive(s1, s2, i1+1, i2);
        return Math.min(length1, length2);

    }
    //leetcode 1092
    public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++)
            dp[i][0] = i;
        for(int j=0; j<=s2.length(); j++)
            dp[0][j] = j;
        String res="";
        for(int i=1;i<=s1.length();i++)
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    if(dp[i-1][j]<dp[i][j-1]){
                        dp[i][j]=1+dp[i-1][j];
                    }else{
                        dp[i][j]=1+dp[i][j-1];
                    }
                }
            }
        int i=s1.length(),j=s2.length();
        while(i>0&&j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                res = s1.charAt(i - 1) + res;
                i--;j--;
            }
            else{
                if(dp[i][j]==dp[i-1][j]+1){
                    res=s1.charAt(i-1)+res;
                    i--;
                }else{
                    res = s2.charAt(j-1)+res;
                    j--;
                }
            }

        }
        res=s1.substring(0,i)+s2.substring(0,j)+res;
        return res;
    }



    public int shortestCommonSequence(String s1,String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        int maxLength=0;
        for(int i=1;i<s1.length()+1;i++)
            for (int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                  dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                maxLength=Math.max(maxLength,dp[i][j]);
            }
        return s1.length()+s2.length()-maxLength;
    }

    public static void main(String[] args){
        ShortestCommonSequence test=new ShortestCommonSequence();
        System.out.println(test.shortestCommonSupersequence("abac","cab"));

    }
}
