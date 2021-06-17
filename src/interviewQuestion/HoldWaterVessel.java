package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HoldWaterVessel {
    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    static int[] nums=new int[100010];
    public static void main(String[] args) throws Exception{
        int n=Integer.parseInt(reader.readLine());
        String[] s=reader.readLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(s[i]);
        }
        int res=0;
        int left=0,right=n-1;
        int high=0;
        while(left<right){
            high=Math.min(nums[left],nums[right]);
            res=Math.max(res,high*(right-left));
            if(nums[left]>nums[right])
                right--;
            else
                left++;
        }
        System.out.println(res);


    }







}
