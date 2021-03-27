package stringPbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		Reader1.init(System.in);
		String str="";
		while((str=Reader1.nextLine())!=null) {
		String[] a=str.split(" ");

		for(int i=a.length-1;i>-1;i--) {
			if(i!=0) {
			System.out.print(a[i]+" ");
			}else {
				System.out.print(a[i]);
			}
		}
		System.out.println("");
		}
	
	}
}
class Reader1 {
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