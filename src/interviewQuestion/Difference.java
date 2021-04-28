package interviewQuestion;

import java.util.Scanner;

public class Difference {
    //get新知识点 前缀和 差分
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[sc.nextInt()+1];
        int[] b = new int[nums.length+1];
        int count = sc.nextInt();
        for (int i = 1; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            insert(b,i,i,nums[i]);
        }
        for(int i=0;i<count;i++)
            insert(b,sc.nextInt(),sc.nextInt(), sc.nextInt());
        for(int i=1;i<nums.length;i++) {
            nums[i] = nums[i - 1] + b[i];
            System.out.print(nums[i - 1] + b[i] + " ");
        }
    }
    public static void insert(int[] b,int l, int r, int c){
        b[l]+=c;
        b[r+1]-=c;
    }



    //直接实现超时
    public static void test(){
        Scanner sc=new Scanner(System.in);
        int[] nums=new int[sc.nextInt()];
        int count=sc.nextInt();
        for(int i=0;i<nums.length;i++)
            nums[i]=sc.nextInt();
        for(int i=0;i<count;i++)
            changeArr(nums,sc.nextInt()-1,sc.nextInt(), sc.nextInt());
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }
    public static void changeArr(int[] nums, int st,int ed, int t){
        for(int i=st;i<ed;i++)
            nums[i]+=+t;
    }
}
