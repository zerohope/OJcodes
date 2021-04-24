package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class LongestRepeatingSubsequence {
    public int LongestRepeatingSub(String s, int i1, int i2){
        if(i1==s.length()||i2==s.length())
            return 0;
        if(i1!=i2&&s.charAt(i1)==s.charAt(i2))
            return 1+LongestRepeatingSub(s,i1+1,i2+1);
        int c1=LongestRepeatingSub(s,i1+1,i2);
        int c2=LongestRepeatingSub(s,i1,i2+1);
        return Math.max(i1,i2);
    }

    public String dpSolver(String s){
        int[][] dp=new int[s.length()+1][s.length()+1];
        int maxLength=0;
        int i1=0,i2=0;
        String res="";
        for(int i=1;i<s.length()+1;i++)
            for(int j=1;j<s.length()+1;j++){
                if(i!=j&&s.charAt(i-1)==s.charAt(j-1))
                   dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if(maxLength<dp[i][j]){
                    maxLength=dp[i][j];
                    i1=i;
                    i2=j;
                }
            }
        for(;i1>0&i2>0;){

                if(s.charAt(i1-1)==s.charAt(i2-1)&&i1!=i2){
                    res=s.charAt(i1-1)+res;
                    i1--;i2--;
                }else {
                    if (dp[i1][i2] == dp[i1 - 1][i2]) {
                        i2--;
                    } else {
                        i1--;
                    }
                }
            }
        return res;
    }
    public static void main(String[] args) {
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        System.out.println(lrs.dpSolver("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"));
    }
}
