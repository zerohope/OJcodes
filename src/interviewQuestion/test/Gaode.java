package interviewQuestion.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Gaode {
    public static int f(int[] a, int v){
        int st=0,end=a.length-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(a[mid]==v)
                return mid;
            else if(a[mid]<v)
                st=mid+1;
            else
                end=mid-1;
        }

        return -1;
    }
    int base=1337;
    int mypow(int a, int k) {
        if (k == 0) return 1;
        a %= base;

        if (k % 2 == 1) {
            // k 是奇数
            return (a * mypow(a, k - 1)) % base;
        } else {
            // k 是偶数
            int sub = mypow(a, k / 2);
            return (sub * sub) % base;
        }
    }
    public static void shuffle(){
        int[] x = {1,2,3,4,5,6,7,8,9};
        List list = new ArrayList();
        for(int i = 0;i < x.length;i++){
            System.out.print(x[i]+", ");
            list.add(x[i]);
        }
        System.out.println();

        Collections.shuffle(list);

        Iterator ite = list.iterator();
        while(ite.hasNext()){
            System.out.print(ite.next().toString()+", ");
        }
    }



    public static void main(String[] args){
        System.out.println(f(new int[]{1,2,3,4,5,5,5,5,5,5,5,5,6,7,8,9,9,9,9,9,9,10},9));



    }



}
