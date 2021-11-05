package Euler;

/*
一种更好的解法
def is_it(n):
    flag = 0
    x = 9
    while n > 0:
        d = n % 10
        if d == x:
            flag += 1
        n //= 100
        x -= 1
    return flag == 9

low = 101010103
high = 138902662

n = low
while n < high:
    if is_it(n ** 2):
        break
    if n % 10 == 3:
        n += 4
    else:
        n += 6

print(n * 10)
*/
public class ConcealedSquare_206 {

    public static void main(String[] args){
    char[] digits={'1','0','2','0','3','0','4','0','5','0','6','0','7','0','8','0','9'};
        calculate(digits,1);
    }
    public static void calculate(char[] digits, int idx){
        if(idx>digits.length-2){
            long d=Long.parseLong(new String(digits));
            int a=(int)Math.sqrt(d);
            long temp=(long)a*(long)a;
            if(temp==d)
                System.out.println(d);
            return ;
        }else{
            for(int i=0;i<=9;i++){
                digits[idx]=(char)('0'+i);
                calculate(digits,idx+2);
            }


        }


    }

}
