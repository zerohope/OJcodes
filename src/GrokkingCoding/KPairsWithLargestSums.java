package GrokkingCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithLargestSums {
    public static List<int[]> findKLargestPairs(int[] nums1,int[] nums2,int k){
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        for(int i=0;i<Math.min(nums1.length,k);i++)
            for (int j=0;j<Math.min(nums2.length,k);j++){
                if(minHeap.size()<k)
                    minHeap.offer(new int[]{nums1[i],nums2[j]});
                else{
                    if(nums1[i]+nums2[j]<minHeap.peek()[0]+minHeap.peek()[1])
                        break;
                    else{
                        minHeap.poll();
                        minHeap.offer(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
            return new ArrayList<>(minHeap);
    }

  public static void main(String[] args){

        int[] l1=new int[]{9,8,2};
        int[] l2=new int[]{100,3,1};
        List<int[]> result=findKLargestPairs(l1,l2,3);
       for(int[] pair:result)
           System.out.println(pair[0]+" "+pair[1]);
  }

}
