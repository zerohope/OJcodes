package GrokkingCoding;

public class TwoSignleNums {

    public static void main(String[] args){
        int[] nums={1,1,1,1,1,2};
        int[] res=findSingleNumbers(nums);
        System.out.println(res[0]+"---"+res[1]);


    }


    public  static int[] findSingleNumbers(int[] nums){
        int n1xn2=0;
        for(int num:nums)
          n1xn2^=num;
        int rightmostSetBit=1;
        while((rightmostSetBit&n1xn2)==0)
            rightmostSetBit=rightmostSetBit<<1;
        int num1=0,num2=0;
        for(int num:nums){
            if((num&rightmostSetBit)!=0)
                num1^=num;
            else
                num2^=num;
        }
        return new int[]{num1,num2};
    }
}
