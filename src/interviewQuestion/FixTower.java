package interviewQuestion;

import java.util.Scanner;

public class FixTower {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int[] cnt=new int[10010];
        int[] ps=new int[10010];
        int maxNum=0;
        for(int i=0;i<n;i++){
            int h=sc.nextInt();
            cnt[h]+=1;
            maxNum=Math.max(maxNum,cnt[h]);
        }
    if(maxNum>=k){
        System.out.println(0);
    }else{
        for(int i=1;i<=10000;i++){
            ps[i]=ps[i-1]+cnt[i]*i;
        }
        int res=Integer.MAX_VALUE;
        for(int h=1,c=0;h<=10000;h++){
            int left=c*h-ps[h-1];
            int right=ps[10000]-ps[h]-h*(n-c-cnt[h]);
            if(c+cnt[h]>=k) res=Math.min(res,left-(c+cnt[h]-k));
            if(n-c>=k) res=Math.min(res,right-(n-c-k));
            res=Math.min(res,left+right-(n-k));
            c+=cnt[h];
        }
        System.out.println(res);

    }

    }



}
