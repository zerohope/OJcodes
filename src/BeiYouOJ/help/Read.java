package help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Read {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char a=1;
    System.out.println((int)a);
		
		
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