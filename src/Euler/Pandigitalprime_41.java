package Euler;

public class Pandigitalprime_41 {
    public static void main(String[] args){
        int n=987654321;
        int res=0;
        for(int i=n;i>1;i--){
            if(judgeDigits(i)){
                if(isPrime(i)){
                    res=i;
                    break;
                }
            }
        }
        System.out.println(res);


    }
    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean judgeDigits(int n){
        int[] nums=new int[10];
        int total=0;
        int size=String.valueOf(n).length();
        while(n>0){
            int idx=n%10;
            if(idx>size||idx==0)
                return false;
            nums[idx]+=1;
            if(nums[idx]>1)
                return false;
            total++;
            n/=10;
        }
            return true;

    }

}
