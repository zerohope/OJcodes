package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluation {
    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> nums=new Stack<>();
    static Stack<Character> opt=new Stack<>();
    //取模不对会出问题
    static int MOD=10000;
    public static void main(String[] args) throws Exception{
       String exp=reader.readLine();
       String res=calculateStack(exp)+"";

       if(res.length()>=4){
           res=res.substring(res.length()-4);
           while(res.charAt(0)=='0'){
               res=res.substring(1);
           }
           System.out.println(res);
       }else{
           System.out.println(res);
       }
    }
   public static void eval(){
        int b=nums.pop();
        int a=nums.pop();
        char c=opt.pop();
        if(c=='+')
            nums.push((a+b)%MOD);
        else
            nums.push((a*b)%MOD);
   }
    public static int calculateStack(String s){
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int v=0,j=i;
                while(j<s.length()&&Character.isDigit(s.charAt(j))) {
                    v = v * 10 + s.charAt(j) - '0';
                    j++;
                }
                nums.push(v%MOD);
                i=j-1;
            }
            else if(c=='+'){
                while(!opt.isEmpty())
                    eval();
                opt.push(c);
            }
            else{
                while(!opt.isEmpty()&&opt.peek()=='*')
                    eval();
                opt.push(c);
            }

        }
    while(!opt.isEmpty())
        eval();
        return nums.peek();
    }




    //超时
    public static int calculate(String s){
        if(!s.contains("+")&&!s.contains("*"))
            return Integer.parseInt(s);

        if(s.contains("+")){
                    int idx=s.indexOf("+");
                    return (calculate(s.substring(0,idx)))%10000+(calculate(s.substring(idx+1)))%10000;
        }else{
            int idx=s.indexOf("*");
                    return (calculate(s.substring(0,idx)))%10000*calculate((s.substring(idx+1)))%10000;
            }
    }

}



