package leetcode;

import java.util.Random;

public class Rand7 {
    public static void main(String[] args){
       int[] count=new int[10];
        for(int i=0;i<10000;i++){
            count[rand10()-1]++;
        }
    }
    public static int rand7(){

        Random r = new Random();
        return r.nextInt(7) + 1;

    }
    public static int rand10() {
        int[][] nums=new int[7][7];
        int num=1;
        for(int i=0;i<7;i++)
            for(int j=0;j<7;j++){
                if(num==11){
                    num-=10;
                }

                nums[i][j]=num;
                num++;

            }
        int i=5,j=5;
        while(i<7&&j<7){
            nums[i][j]=0;
            if(j==6){
                j=j-6;
                i++;
                continue;
            }
            j++;
        }


        int r= nums[rand7()-1][rand7()-1];
        if(r==0)
            return rand10();
        else
            return r;
    }

}
