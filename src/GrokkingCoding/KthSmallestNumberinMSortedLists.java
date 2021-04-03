package GrokkingCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberinMSortedLists {
    public static int findKthSmallest(List<Integer[]> lists, int k){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(Integer[] list:lists){
            for(int i=0;i<Math.min(list.length,k);i++) {
                if (maxHeap.size() < k)
                    maxHeap.offer(list[i]);
                else if (maxHeap.peek() > list[i]) {
                    maxHeap.poll();
                    maxHeap.offer(list[i]);
                } else
                    break;
            }
        }

     return maxHeap.peek();

    }
    public static void main(String[] args){
        Integer[] l1=new Integer[]{2,6,8};
        Integer[] l2=new Integer[]{3,6,7};
        List<Integer[]> list=new ArrayList<>();
        list.add(l1);
        list.add(l2);
        System.out.println(findKthSmallest(list,5));
    }



}


