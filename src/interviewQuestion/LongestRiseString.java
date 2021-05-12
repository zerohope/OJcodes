package interviewQuestion;

import java.util.Scanner;

public class LongestRiseString {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        int st=0,skip=1,maxLength=0,nst=0,ed=0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] > arr[ed]) {
                ed = i;
                if (skip == 0)
                    maxLength = Math.max(maxLength, ed - st);
                else
                    maxLength = Math.max(maxLength, ed - st + 1);
            } else {
                if (skip == 1) {
                    skip--;
                    nst = i;
                    continue;
                } else {
                    skip = 1;
                    st = nst;
                    ed = nst;
                    i=nst;
                }
            }
        }
        st=0;skip=1;nst=0;ed=0;
        for(int i=1;i<arr.length;i++) {
            if (arr[i] > arr[ed]) {
                ed = i;
                if (skip == 0)
                    maxLength = Math.max(maxLength, ed - st);
                else
                    maxLength = Math.max(maxLength, ed - st + 1);
            } else {
                if (skip == 1) {
                    skip--;
                    if(ed-1>=st)
                    ed--;
                    nst = i;
                    i--;
                    continue;
                } else {
                    skip = 1;
                    st = nst;
                    ed = nst;
                    i=nst;
                }
            }
        }
        //一定要删一个数组元素，不能不删
        if(maxLength==arr.length)
            System.out.println(maxLength-1);
        else
          System.out.println(maxLength);
    }

}
