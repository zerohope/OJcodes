package interviewQuestion;

import java.util.Scanner;

public class TheKthNumber {
    static int N=100010;
    static int[] arr=new int[N];
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt(),k=sc.nextInt();
    for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println(quickSelect(0,n-1,k));

    }


   static int quickSelect(int p,int q, int k){
        if(p==q) return arr[p];
        int flag=arr[p];
        int x=p-1,y=q+1;
        while(x<y){
            do{ x++; } while(arr[x]<flag);
            do{y--;} while(arr[y]>flag);
            if(x<y){
                int temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
        }
        if(k<=y-p+1)
            return quickSelect(p,y,k);
        return quickSelect(y+1,q,k-(y-p+1));

   }




}
