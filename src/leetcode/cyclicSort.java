public class cyclicSort {

    public static void main(String[] args){

        findDuplicate(new int[]{3,2,1});



    }
    public static void findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int j=nums[i]-1;
            if(i!=j){
                swap(nums,i,j);

            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){

                System.out.println(nums[i]);
        }

    }
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
