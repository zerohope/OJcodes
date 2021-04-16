package GrokkingDynamicProgramming.Pattern4PalindromicSubsequence;

public class LongestPalindromicSubstring {
    public int findLength(String s,int left,int right){
        if(left>right)
            return 0;
        if(check(s,left,right))
            return right-left+1;
        else if(check(s,left+1,right)||check(s,left,right-1))
            return right-left;
        int c1=findLength(s,left+1,right);
        int c2=findLength(s,left,right-1);
        return Math.max(c1,c2);
    }
    public Boolean check(String s,int left, int right){

       if(left>right)
           return false;
       while(left<=right){
           if(s.charAt(left++)!=s.charAt(right--)){
               return false;
           }
       }
        return true;
    }
    //教程做法，不需要check函数,直接比较长度
    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
            return 1;

        // case 1: elements at the beginning and the end are the same
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            int remainingLength = endIndex - startIndex - 1;
            // check if the remaining string is also a palindrome
            if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
                return remainingLength + 2;
        }

        // case 2: skip one character either from the beginning or the end
        int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }

    public int dpSolver(String s){
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i]=1;
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==j-i-1)
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        return dp[0][s.length()-1];
    }
    public int findLPSLength(String st) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = true;

        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    }
                }
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.dpSolver("abdbca"));
        System.out.println(lps.dpSolver("cddpd"));
       System.out.println(lps.dpSolver("pqr"));
    }


}
