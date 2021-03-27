package GrokkingCoding;

public class CeilingofaNumber {
    public static void main(String[] args){
        System.out.println(searchCeilingOfANumber(new int[]{4,6,10},-1));



    }
    public static int searchCeilingOfANumber(int[] arr,int key){
        if(key>arr[arr.length-1])
            return -1;
        int left=0,right=arr.length-1,mid=0;
        while(left<=right){
            mid=(right+left)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[mid]>key)
                right=mid-1;
            if(arr[mid]<key)
                left=mid+1;
        }

        return left;

    }


}
