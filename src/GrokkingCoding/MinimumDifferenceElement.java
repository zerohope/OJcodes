package GrokkingCoding;

public class MinimumDifferenceElement {
    public  static int searchMinDiffElement(int[] arr, int key){
        int left=0,right=arr.length-1,mid=0;
        if(key>arr[right])
            return arr[right];
        if(key<arr[left])
            return arr[left];
        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]==key)
                return arr[mid];
            if(arr[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }

        return (arr[left]-key<key-arr[left-1])?arr[left]:arr[left-1];
    }

    public static void main(String[] args){
        System.out.println(searchMinDiffElement(new int[]{4,6,10},17));



    }



}
