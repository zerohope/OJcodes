package GrokkingDynamicProgramming.Pattern4PalindromicSubsequence;

public class PalindromicPartitioning {
    public int findMPPCuts(String st) {
        return this.findMPPCutsRecursive(st, 0, st.length()-1);
    }

    private int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
        // we don't need to cut the string if it is a palindrome
        if(startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
            return 0;

        // at max, we need to cut the string into its 'length-1' pieces
        int minimumCuts = endIndex-startIndex;
        for (int i=startIndex; i <= endIndex; i++) {
            if(isPalindrome(st, startIndex, i)){
                // we can cut here as we have a palindrome from 'startIndex' to 'i'
                minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i+1, endIndex));
            }
        }
        return minimumCuts;
    }

    public int dpSolver(String s){
        boolean[][] dp=new boolean[s.length()][s.length()];
        int[] cutMin=new int[s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i]=true;
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1||dp[i+1][j-1])
                        dp[i][j]=true;
                }
            }
        for(int i=s.length()-1;i>=0;i--) {
            cutMin[i] = s.length() - i - 1;
            for (int j = s.length() - 1; j >=i; j--) {
                if (dp[i][j]){
                    cutMin[i]=(j==s.length()-1)?0:Math.min(cutMin[i],1+cutMin[j+1]);
                }
            }
        }
        return cutMin[0];
    }



    private boolean isPalindrome(String st, int x, int y) {
        while(x < y) {
            if(st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromicPartitioning mpp = new PalindromicPartitioning();
        System.out.println(mpp.findMPPCuts("abcb"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }

}
