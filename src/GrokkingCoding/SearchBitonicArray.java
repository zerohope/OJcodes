package GrokkingCoding;

public class SearchBitonicArray {
    public static int search(int[] arr, int key){
        int left=0,right=arr.length-1,mid=0;
        while(left<right){
            mid=(left+right)/2;
            if(arr[mid]<arr[mid-1])
                right=mid-1;
            else if(arr[mid]<arr[mid+1])
                left=mid+1;
            else
                break;
        }
        int rs=findKey(arr,0,mid,key,true);
        return rs==-1?findKey(arr,mid,arr.length-1,key,false):rs;
    }
    public static int findKey(int[] arr,int st,int ed,int key,boolean flag){
        int mid=0;
        while(st<=ed) {
            mid = (st + ed) / 2;
            if (arr[mid] < key) {
                if (flag)
                    st = mid + 1;
                else
                    ed = mid - 1;
            } else if (arr[mid] > key) {
                if (flag)
                    ed = mid - 1;
                else
                    st = mid + 1;
            } else
                return mid;
        }
            return -1;
    }
    static int a=5;
public static void main(String[] args){
    //System.out.println(search(new int[]{3,8,3,1},8));
    int a=-5;
    System.out.println(a);

}
}
