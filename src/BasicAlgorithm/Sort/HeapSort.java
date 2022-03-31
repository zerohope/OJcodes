package BasicAlgorithm.Sort;

import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] arr=new int[m+1];
        for(int i=1;i<=m;i++){
            arr[i]=sc.nextInt();
        }
        int size=m,i=m/2;
        while (i>0){
            down(arr,i,size);
            i--;
        }
        for(int y=1;y<n+1;y++){
            System.out.println(arr[1]);
            arr[1]=arr[size-1];
            size--;
            down(arr,1,size);
        }


    }


    public static void down(int[] arr, int i,int size){
        int left=2*i,right=2*i+1;
        int min=i;
        if(left<=size&&arr[min]>arr[left])
            min=left;
        if(right<=size&&arr[min]>arr[right])
            min=right;
        if(min!=i) {
            swap(arr, min, i);
            down(arr,min,size);
        }


    }
    public static void swap(int[] arr,int x,int y){
        int temp=arr[x];
         arr[x]=arr[y];
        arr[y]=temp;

    }

}
