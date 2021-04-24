package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class SubsequencePatternMatching {
    public int recursiveSolution(String s,String p, int i1,int i2){
        if(i2==p.length())
            return 1;
        if(i1==s.length())
           return 0;

        int c1=0,c2=0;
       if(s.charAt(i1)==p.charAt(i2))
        c1=recursiveSolution(s,p,i1+1,i2+1);
       c2=recursiveSolution(s,p,i1+1,i2);

       return c1+c2;
    }
    private int findSPMCountRecursive(String str, String pat, int strIndex, int patIndex) {

        // if we have reached the end of the pattern
        if(patIndex == pat.length())
            return 1;

        // if we have reached the end of the string but pattern has still some characters left
        if(strIndex == str.length())
            return 0;

        int c1 = 0;
        if(str.charAt(strIndex) == pat.charAt(patIndex))
            c1 = findSPMCountRecursive(str, pat, strIndex+1, patIndex+1);

        int c2 = findSPMCountRecursive(str, pat, strIndex+1, patIndex);

        return c1 + c2;
    }
   //undebug
    public int recursiveAndFor(String s,String p, int i1,int i2){
        if(i1==s.length())
            return 0;
        if(i2==p.length())
            return 1;
        int c1=0,c2=0;
        for(int i=i1;i<s.length();i++) {
            if (s.charAt(i) == p.charAt(i2))
                c1 += recursiveAndFor(s, p, i+1, i2 + 1);
            else
                c2+=recursiveAndFor(s, p, i+1, i2 );
        }
        return c1+c2;
    }

    public int dpSolver(String s,String p){
        int[][] dp=new int[s.length()+1][p.length()+1];
        //******************
        for(int i=0; i<=s.length(); i++)
            dp[i][0] = 1;
        //*****************
        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1))
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                else
                    dp[i][j]=dp[i-1][j];
            }

return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
        SubsequencePatternMatching spm = new SubsequencePatternMatching();
        System.out.println(spm.recursiveAndFor("baxmx", "ax",0,0));
        System.out.println(spm.findSPMCountRecursive("tomorrow", "tor",0,0));
    }
}
