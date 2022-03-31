package BasicAlgorithm.Sort;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    public void sort(int[] nums,int left,int right){
        if(left>=right)
            return ;
        int mid=(left+right)>>1;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        int[] done=new int[right-left+1];
        int i=left,j=mid+1;
        int idx=0;
        while(i<mid+1&&j<right+1){
            if(nums[i]<nums[j]){
                done[idx++]=nums[i++];
            }else{
                done[idx++]=nums[j++];
            }
        }
        while(i<mid+1)
            done[idx++]=nums[i++];
        while(j<right+1)
            done[idx++]=nums[j++];
        idx--;
        for(;idx>=0;idx--){
            nums[right--]=done[idx];
        }

    }
}
