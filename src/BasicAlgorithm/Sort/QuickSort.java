package BasicAlgorithm.Sort;
//快速排序的acwing社区实现
public class QuickSort {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);

        return nums;
    }
    public void sort(int[] nums,int left,int right){
        if(left>=right)
            return;
        int i=left-1,j=right+1;
        int x=nums[(i+j)>>1];
        while(i<j){
            do{
                i++;
            }while(nums[i]<x);
            do{
                j--;
            }while(nums[j]>x);
            if(i<j) swap(nums,i,j);
        }
        sort(nums,left,j);
        sort(nums,j+1,right);


    }
    public void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }



}
