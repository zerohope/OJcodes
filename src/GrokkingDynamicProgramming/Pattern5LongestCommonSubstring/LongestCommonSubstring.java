package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class LongestCommonSubstring {

    public int dpSolver(String text1,String text2){
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        int maxLength = 0;
        for(int i=1;i<=text1.length();i++)
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                maxLength=Math.max(maxLength,dp[i][j]);

            }
        return maxLength;

    }




    public int findLongestSubstring(String text1,String text2,int i, int j, int count){
        if(i==text1.length()||j==text2.length())
            return count;

        if(text1.charAt(i)==text2.charAt(j))
            count=findLongestSubstring(text1,text2,i+1,j+1,count+1);

        int temp1=findLongestSubstring(text1,text2,i+1,j,0);
        int temp2=findLongestSubstring(text1,text2,i,j+1,0);

        return Math.max(count,Math.max(temp1,temp2));
    }


    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.findLongestSubstring("bd", "bd",0,0,0));
        System.out.println(lcs.findLongestSubstring("passport", "ppsspt",0,0,0));
    }

}
