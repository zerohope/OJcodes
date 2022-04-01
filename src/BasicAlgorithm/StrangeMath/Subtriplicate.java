package BasicAlgorithm.StrangeMath;

import java.util.Scanner;

public class Subtriplicate {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double nb=sc.nextDouble();
        Newton(nb);




    }

    public static void BinarySearch(double nb){
        double l=-10000,r=10000;
        while (r-l>1e-6){
            double mid=(l+r)/2;
            if(mid*mid*mid<nb){
                l=mid;
            }else{
                r=mid;
            }
        }
        System.out.println(String.format("%.6f", l));
    }
//泰勒展开
    public static void Newton(double nb){
        double n=nb;
        double n_next=n-(n*n*n-nb)/(3*n*n);
        while (Math.abs(n_next-n)>1e-5){
            n=n_next;
            n_next=n-(n*n*n-nb)/(3*n*n);
        }
        System.out.println(String.format("%.6f", n));
    }


}
