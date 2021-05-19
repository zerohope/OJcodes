package interviewQuestion;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DynamicMedian {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        String res="";
        for(int i=0;i<p;i++){
            int no=sc.nextInt(),size= sc.nextInt();
            int[] nums=new int[size];
            for(int j=0;j<size;j++)
                nums[j]=sc.nextInt();
            res+=calMedian(nums,i+1);

        }
        System.out.println(res.substring(0,res.length()-1));
    }
    public static String calMedian(int[] nums,int idx){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->a-b);
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        String res=idx+" "+(nums.length+1)/2+"\n";
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(maxHeap.isEmpty()||nums[i]<maxHeap.peek()){
                maxHeap.offer(nums[i]);
            }else{
                minHeap.offer(nums[i]);
            }
            while(maxHeap.size()-minHeap.size()>1){
                minHeap.offer(maxHeap.poll());
            }
            while(minHeap.size()>maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.size()>minHeap.size()) {
                res += maxHeap.peek() + " ";
                count++;
            }
            if(count==10&&i<nums.length-1) {
                res += "\n";
            count-=10;
            }
        }

     return res+"\n";
    }

}
