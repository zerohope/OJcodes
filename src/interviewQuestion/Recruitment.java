package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recruitment {
    //dp+滚动数组
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int step=sc.nextInt();
        for(int i=0;i<step;i++) {
            int peoNbs = sc.nextInt();
            int[] nums = new int[sc.nextInt()];
            for (int j = 0; j < nums.length; j++)
                nums[j] = sc.nextInt();
            int[][] dp=new int[2][1];
            dp[1&1][0]=0;
            for(int j=2;j<=peoNbs;j++){
                dp[j&1][0]=(dp[(j-1)^1][0]+nums[(peoNbs-j)%nums.length])%j;
            }
            System.out.println(dp[peoNbs&1][0]);
        }

    }

    //超时
    public static void test(){
        Scanner sc=new Scanner(System.in);
        int step=sc.nextInt();
        for(int i=0;i<step;i++){
            int peoNbs=sc.nextInt();
            int[] nums=new int[sc.nextInt()];
            for(int j=0;j<nums.length;j++)
                nums[j]=sc.nextInt();
            List<Integer> candidates=new ArrayList<>();
            for(int j=0;j<peoNbs;j++)
                candidates.add(j);
            int cFlag=0,nFlag=0;
            while(candidates.size()>1){
                cFlag=(cFlag+nums[nFlag]-1)%peoNbs;
                candidates.remove(cFlag);
                nFlag=(++nFlag)%nums.length;
                peoNbs=candidates.size();
            }
            System.out.println(candidates.get(0));
        }

    }
}
