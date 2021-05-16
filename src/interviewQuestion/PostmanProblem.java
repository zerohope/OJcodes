package interviewQuestion;

import java.util.Arrays;

import java.util.Scanner;

public class PostmanProblem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] nums=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++)
           nums[i]=sc.nextInt();
        Arrays.sort(nums);
        int res=0;
        int pos=nums[nums.length/2];
        for(int i=0;i<nums.length;i++)
            res+=Math.abs(pos-nums[i]);
        System.out.println(res);

    }






}
