package interviewQuestion;

import java.util.Scanner;

public class CopyBookPages {
    static int[] books=new int[510];
    static int[] L;
    static int[] R;
    static int k,m;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        k=sc.nextInt();
        int left=0,right=0;
        L=new int[510];
        R=new int[510];
        for(int i=1;i<=m;i++){
            books[i]=sc.nextInt();
            left=Math.max(left,books[i]);
            right+=books[i];
        }

        while(left<right){
            int mid=left+right>>1;
            if(check(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        check(left);
        for(int i=k;i>0;i--)
            System.out.println(L[i]+" "+R[i]);
    }
public static boolean check(int mid){
        int cnt=1,total=0;
        R[cnt]=m;
        for(int i=m;i>0;i--){
            if(total+books[i]<=mid) {
                total += books[i];
            }
            else{
                L[cnt]=i+1;
                cnt++;
                R[cnt]=i;
                total=books[i];
            }
         }
        L[cnt]=1;
    return cnt<=k;

}


}
