package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class EditDistance {
    public int findMinOperations(String s1, String s2) {
        return findMinOperationsRecursive(s1, s2, 0, 0);
    }

    private int findMinOperationsRecursive(String s1, String s2, int i1, int i2) {
        if(i1==s1.length())
          return s2.length()-i2;
        if(i2==s2.length())
            return s1.length()-i1;
        if(s1.charAt(i1)==s2.charAt(i2))
            return 1+findMinOperationsRecursive(s1,s2,i1+1,i2+1);
        int c1=1+findMinOperationsRecursive(s1,s2,i1+1,i2);
        int c2=1+findMinOperationsRecursive(s1,s2,i1+1,i2+1);
        int c3=findMinOperationsRecursive(s1,s2,i1,i2+1);
        return Math.min(c1,Math.min(c2,c3));
    }
    private int dpSolver(String s1,String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length();i++)
            dp[i][0]=i;
        for(int j=0;j<s2.length();j++)
            dp[0][j]=j;
        for(int i=1;i<s1.length()+1;i++)
          for(int j=1;j<s2.length()+1;j++)
              if(s1.charAt(i)==s2.charAt(j)){
                  dp[i][j]=dp[i-1][j-1];
              }else{
                  dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
              }

        return dp[s1.length()][s2.length()];
    }

}
