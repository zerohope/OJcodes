package interviewQuestion;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class DivideCandy {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long[] candy=new long[sc.nextInt()];
        long aver=0;
        for(int i=0;i<candy.length;i++){
            candy[i]=sc.nextInt();
            aver+=candy[i];
        }
        aver=aver/candy.length;
        candy[0]=0;
        for(int i=1;i<candy.length;i++){
            candy[i]=aver-candy[i]+candy[i-1];
        }
        Arrays.sort(candy);
        long pos=candy[candy.length/2],res=0;
        for(int i=0;i<candy.length;i++){
            res+= Math.abs(pos-candy[i]);
        }
        System.out.println(res);

    }

}
