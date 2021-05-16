package interviewQuestion;

import java.util.Scanner;

public class DivideCards {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] nums=new int[sc.nextInt()];
    int aver=0;
    for(int i=0;i<nums.length;i++){
        nums[i]=sc.nextInt();
        aver+=nums[i];
    }
    aver=aver/nums.length;
    int x=0,res=0;
    for(int i=0;i<nums.length;i++){
       x=nums[i]-aver+x;
       if(x!=0)
        res++;
    }
        System.out.println(res);
    }

}
