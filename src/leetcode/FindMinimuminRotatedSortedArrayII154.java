package leetcode;

public class FindMinimuminRotatedSortedArrayII154 {
    public static int findMin(int[] nums) {
        int left=0,right=nums.length-1,mid=0,max=0,idx=0;
        while(left<right){
            mid=left+(right-left)/2;
            if(mid<right&&nums[mid]>nums[mid+1])
                return nums[mid+1];
            if(mid>left&&nums[mid-1]>nums[mid])
                return nums[mid];
            if(nums[left]==nums[mid]&&nums[mid]==nums[right]){
                if(nums[left]>nums[left+1])
                    return left+1;
                ++left;
                if(nums[right]<nums[right-1])
                    return right;
                --right;
            }else if(nums[left]<nums[mid]||(nums[left]==nums[mid]&&nums[mid]>nums[right]))
                left=mid+1;
            else
                right=mid-1;

        }
        return nums[0];
    }
    public static void main(String[] args){
        System.out.println(findMin(new int[]{1,1,3,1}));

    }

}
