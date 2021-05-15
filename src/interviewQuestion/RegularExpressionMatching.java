package interviewQuestion;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=1;i<s.length()+1;i++)
            dp[i][0]=false;
        //注：s为空的时候，与p还是有可能匹配的
//        for(int i=1;i<p.length()+1;i++)
//            dp[0][i]=false;
        for(int i=0;i<s.length()+1;i++)
            for(int j=1;j<p.length()+1;j++){
                if(j+1<p.length()+1&&p.charAt(j)=='*')
                    continue;
                if(i==0&&p.charAt(j-1)!='*')
                    dp[i][j]=false;
                if(i>0&&p.charAt(j-1)!='*')
                    dp[i][j]=dp[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.');
                else if(p.charAt(j-1)=='*')
                    dp[i][j]=dp[i][j-2]||i>0&&dp[i-1][j]&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.');

        }
        return dp[s.length()][p.length()];
    }


}
