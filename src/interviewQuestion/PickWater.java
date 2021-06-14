package interviewQuestion;


import java.util.Scanner;
import java.util.Stack;

public class PickWater {
    static int[] nums=new int[100010];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();
        Stack<Integer> s=new Stack<>();

        int res=0;
        for(int i=0;i<n;i++){
            int last=0;
            while(!s.isEmpty()&&nums[s.peek()]<=nums[i]){
                    res+=(nums[s.peek()]-last)*(i-s.peek()-1);
                    last=nums[s.peek()];
                    s.pop();
                }
            if(!s.isEmpty())
                res+=(nums[i]-last)*(i-s.peek()-1);
            s.push(i);
            }

        System.out.println(res);
    }

}
