package Model;

public class FastPower {

	public static void main(String[] args) {

		fastPower(2,10);
        Math.pow(2, 10);
	}
	//������
    public static void fastPower(int a, int b) {
    	Math.pow(2, 10);
    	int ans=1;
    	int base=a;
    	while(b!=0 ) {
    		if ((b & 1) != 0) { 
                ans = ans * base;
            }
            base = base * base;
            b >>= 1;
        }
    	 
        System.out.println(ans);
    }
    
    //��С��Լ��
    int gcd(int a,int b){
        while( b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
