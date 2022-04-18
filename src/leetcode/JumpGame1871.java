package leetcode;

public class JumpGame1871 {
    public static void main(String[] args){




    }

    //dp超时
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] steps=s.toCharArray();
        int l=s.length();
        boolean[] dp=new boolean[l];
        if(steps[l-1]=='1')
            return false;
        dp[l-1]=true;
        for(int i=l-2;i>=0;i--){
            if(steps[i]=='0'){
                for(int j=i+minJump;j<=Math.min(l-1,i+maxJump);j++){
                    dp[i]|=dp[j];
                }
            }
        }
        return dp[0];


    }
    //dp改滑动窗口
    public boolean canReachUpdate(String s, int minJump, int maxJump) {
        char[] steps=s.toCharArray();
        int l=s.length();
        boolean[] dp=new boolean[l];
        if(steps[l-1]=='1'||steps[0]=='1')
            return false;
        dp[0]=true;
        int cnt=1;
        for(int i=minJump;i<l;i++){
           if(steps[i]=='0'&&cnt>0)
               dp[i]=true;
           if(i>=maxJump&&dp[i-maxJump])
               cnt--;
           if(dp[i-minJump+1])
               cnt++;

        }
        return dp[l-1];


    }

}
