package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ContinuousSubarrayMaxValue {
    public static int maxSubArray(int[] nums) {
        int max=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,0);
            max=nums[i]+max;
            res=Math.max(res,max);
        }
        return res;


    }
public static void main(String[] args){

    System.out.println(maxSubArray(new int[]{-3, -8, -10, -7, -6, -6, -4}));


}


}
