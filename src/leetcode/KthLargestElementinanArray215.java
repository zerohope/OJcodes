package leetcode;

import java.util.Arrays;

public class KthLargestElementinanArray215 {
    public static int findKthLargest(int[] nums, int k) {
        k=nums.length-k+1;
        return findTheNumber(nums,k,0,nums.length-1);
    }
    public static int findTheNumber(int[] nums,int k,int start,int end){
        int p=findPosition(nums,start,end);
        if(p==k-1)
            return nums[p];
        if(p>k-1)
            return findTheNumber(nums,k,start,p-1);
        return findTheNumber(nums,k,p+1,end);
    }
    public static int findPosition(int[] nums,int start,int end){
        if(start==end)
            return start;
        int medin=medianOfMedians(nums,start,end);
        for(int i=start;i<end;i++){
            if(nums[i]==medin)
                swap(nums,i,end);
        }
        int pivot=nums[end];
        for(int i=start;i<end;i++){
            if(nums[i]<pivot){
              swap(nums,start++,i);
            }
        }
        swap(nums,start,end);
        return start;
    }
    public static int medianOfMedians(int[]nums,int start,int end){
        int n=end-start+1;
        if(n<5)
            return nums[start];
        int numOfPositions=n/5;
        int[] medians=new int[numOfPositions];
        for(int i=0;i<numOfPositions;i++){
            int partitioinStart=start+i*5;
            Arrays.sort(nums,partitioinStart,partitioinStart+5);
            medians[i]=nums[partitioinStart+2];
        }
     return findPosition(medians,0,numOfPositions-1);

    }
    public static void swap(int[] nums, int p,int q){
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }
    public static void main(String[] args){
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
