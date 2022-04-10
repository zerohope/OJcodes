package interviewQuestion;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxInWindows {

    public int[] maxInWindows(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        LinkedList<Integer> q=new LinkedList<>();

        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i])
                q.removeLast();
            q.addLast(i);
            if(i-q.peekFirst()>=k)
                q.removeFirst();
            if(i>=k-1)
                res[i-k+1]=nums[q.peekFirst()];
        }




        return res;
    }








    //最大堆解，acwing可以过，leetcode超时
    public int[] maxInWindows1(int[] nums, int k) {
        int[] res=new int[nums.length-k];
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<k;i++){
            maxHeap.offer(nums[i]);
        }
        int flag=0;
        res[flag++]=maxHeap.peek();
        for(int i=k;i<nums.length;i++){
            maxHeap.remove(nums[i-k]);
            maxHeap.offer(nums[i]);
            res[flag++]=maxHeap.peek();
        }

        return res;
    }
}
