package help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResetStrings {

	public static void main(String[] args) throws IOException {
		Reader11.init(System.in);
		int loop=Reader11.nextInt();
		while(loop>0) {
			resetSt(Reader11.next());
			loop--;
		}
		
	}
	
   public static void resetSt(String st) {
	   int[] b=new int[26];
	   for(int i=0;i<st.length();i++) {
		 int j=st.charAt(i)-'a';
          b[j]+=1; 
	   }
	   char[] a=new char[] {'a','b','c','d','e','f',
			   'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	   
           String end="";
          int  i=0;
            Character s=' ';
      while(i<=b.length-1) {
           if(b[i]>0) {
            if(a[i]==s) {
            if(i+1<b.length-1&&b[i+1]==0||i+1>=b.length)
            if(end.length()==2||end.length()>2&&end.charAt(end.length()-2)!=a[i]) {
              String tp=end.substring(end.length()-2);
              end=end.substring(0,end.length()-2);
              end+=a[i]+tp;
              b[i]=b[i]-1;
              s=end.charAt(end.length()-1);
              i=0;
            }	
            	i++;
            	continue;
            }	
        	end+=a[i];
        	s=a[i];
        	b[i]=b[i]-1;
        	i=0;
           
        }else {
        	i++;
        }
      }
      if(end.length()<st.length()) {
    	  System.out.println(-1);
      }else {
        System.out.println(end);
      }
   }    
}
class Reader11 {
	static BufferedReader reader; 
	static StringTokenizer tokenizer;

   static void init(InputStream input) { 
	   reader = new BufferedReader( new InputStreamReader(input) ); 
	   tokenizer = new StringTokenizer(""); }

   static String next() throws IOException { 
    	   while ( ! tokenizer.hasMoreTokens()) 
    	   { 
    		   tokenizer = new StringTokenizer( reader.readLine() );
    	   }
    	   return tokenizer.nextToken(); 
    	   }

static int nextInt() throws IOException {
	return Integer.parseInt( next() );
}

static double nextDouble() throws IOException {
	return Double.parseDouble(next() ); } 

static String nextLine() throws IOException {

	return reader.readLine();
}


}   

