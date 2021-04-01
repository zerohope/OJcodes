package GrokkingCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static int maxDistinctNum(int arr[], int n, int K)
    {
        // Complete the function
        int res=0;
        // Complete the function
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        Map<Integer,Integer> digitsFrenquency=new HashMap<>();
        for(int i=0;i<n;i++)
            digitsFrenquency.put(arr[i],digitsFrenquency.getOrDefault(arr[i],0)+1);
        minHeap.addAll(digitsFrenquency.entrySet());
        while(K>0){
            Map.Entry<Integer,Integer> entry=minHeap.poll();
            int freq=entry.getValue();
            if(freq==1){
                res++;
            }else{
                if(K-freq+1>0){
                    res++;
                    K=K-freq+1;
                }else{
                    break;
                }

            }
        }

        return res;
    }
    public static void main(String[] args){
        maxDistinctNum(new int[]{18,15,14,20,1,10,14,12,13,17,17,2,14,3,5,7,17,3},18,1);

    }

}
