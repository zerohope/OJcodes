package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class StringsInterleaving {
    //无法构建dp方程
    public boolean recursionSolver(String m, String n, String p,int i1, int i2,String t){
        if(i1==m.length())
          return (t+n.substring(i2)).equals(p);
        if(i2==n.length())
          return (t+m.substring(i1)).equals(p);
        return recursionSolver(m,n,p,i1+1,i2,t+m.charAt(i1))||recursionSolver(m,n,p,i1,i2+1,t+n.charAt(i2));
    }
    //Tutorial idea
    public boolean findSIRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex){
        // if we have reached the end of the all the strings
        if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
            return true;

        // if we have reached the end of 'p' but 'm' or 'n' still have some characters left
        if(pIndex == p.length())
            return false;

        boolean b1=false, b2=false;
        if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
            b1 = findSIRecursive(m, n, p, mIndex+1, nIndex, pIndex+1);

        if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
            b2 = findSIRecursive(m, n, p, mIndex, nIndex+1, pIndex+1);

        return b1 || b2;


    }

    public boolean dpSolver(String m, String n, String p){
        boolean[][] dp=new boolean[m.length()+1][n.length()+1];
        dp[0][0]=true;
        for(int i=1;i<m.length()+1;i++){
            dp[i][0]=false;
            if(m.charAt(i-1)==p.charAt(i-1)){
                dp[i][0]|=dp[i-1][0];
            }
        }
        for(int i=1;i<n.length()+1;i++){
            dp[0][i]=false;
            if(n.charAt(i-1)==p.charAt(i-1)){
                dp[0][i]|=dp[0][i-1];
            }
        }
        for(int i=1;i<m.length()+1;i++)
            for(int j=1;j<n.length()+1;j++){
                dp[i][j]=false;
                if(m.charAt(i-1)==p.charAt(i+j-1))
                    dp[i][j]|=dp[i-1][j];
                if(n.charAt(j-1)==p.charAt(i+j-1))
                    dp[i][j]|=dp[i][j-1];
            }
        return dp[m.length()][n.length()];
    }
    public static void main(String[] args) {
        StringsInterleaving si = new StringsInterleaving();
        System.out.println(si.recursionSolver("abd", "cef", "abcdef",0,0,""));
        System.out.println(si.recursionSolver("abd", "cef", "adcbef",0,0,""));
        System.out.println(si.recursionSolver("abc", "def", "abdccf",0,0,""));
        System.out.println(si.recursionSolver("abcdef", "mnop", "mnaobcdepf",0,0,""));
    }
}
