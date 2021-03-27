package OOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class myChess {
public static void main(String[] args) {
int t=0;
int su=0;
String s;
try {
    System.out.print("Please inuput an integer");
BufferedReader br= new  BufferedReader( new InputStreamReader(System.in));
    s=br.readLine();
s=br.readLine();
    t=Integer.parseInt(s);
} catch(IOException e ) {}
System.out.println("你输入了数字:"+t);
if (t<1)
{  su=3*t;}
else
{   
	su=4*t-t*t;    

}
System.out.println("输出的su=:"+su);
}
}
