package stringPbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//³¬Ê±°¡³¬Ê±
public class DBSearch {
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int tms=Reader.nextInt();
		String end="";
		for(int i=0;i<tms;i++) {
			int pnb=Reader.nextInt();
			int snb=Reader.nextInt(); 
			List<People> pe=new ArrayList<People>();
			for(int j=0;j<pnb;j++) {
				pe.add(new People(Reader.next(),Reader.next(),Reader.next()));				
			}
			for(int k=0;k<snb;k++) {
				end+=searchEnd(pe,Reader.nextLine());
			}
		}
		String[] ends=end.split(" ");
		for(int i=0;i<ends.length;i++) {
			System.out.println(ends[i]);
		}
	}

	public static String searchEnd(List<People> peee, String rcd) {
		List<People> p=new ArrayList<People>();
		p.addAll(peee);
		String flag="";
     	String[] pd=new String[]{"","","","",""};
		String[] rs=rcd.split(" ");
		for(int i=0;i<rs.length;i++) {
			if(rs[i].contains("Name")) {
				pd[0]=rs[i].split("'")[1];
			};
			if(rs[i].contains("Sex")) {
				pd[1]=rs[i].split("'")[1];
			};
			if(rs[i].contains("Birthday")) {
				String[] bday=rs[i].split("'")[1].split("/");
				pd[2]=bday[0];
				pd[3]=bday[1];
				pd[4]=bday[2];
			};
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<p.size();j++) {
				if(pd[i].equals("")) {
					continue;
				}else {				
				switch (i) {
				case 0:
                   if(!p.get(j).name.equals(pd[0])) {
                	   p.remove(j);
                	   j=j-1;
                   }					
					break;
                case 1:
                   if(!p.get(j).sex.equals(pd[1])) {
                	   p.remove(j);
                	   j=j-1;
                    }
					break;
                case 2:
					if(pd[2].equals("*")) {
						break;
					}else {
						 if(!p.get(j).byear.equals(pd[2])) {		               
		                	   p.remove(j);	     
		                	   j=j-1;
					}
						 }
					break;
                case 3:
                	if(pd[3].equals("*")) {
						break;
					}else {
						 if(!p.get(j).bmonth.equals(pd[3])) {	
		                	   p.remove(j);	
		                	   j=j-1;
					}
						
						 }
					break;
                case 4:
                	if(pd[4].equals("*")) {
						break;
					}else {
						 if(!p.get(j).bday.equals(pd[4])) {		               
		                	   p.remove(j);	   
		                	   j=j-1;
					}
						 }
					break;
				default:
					break;
				}		
				}
			}	
			
		}
		if(p.isEmpty()) {
		return "NULL ";
		}else {
			for(int i=0;i<p.size();i++) {
				flag+=p.get(i).name+" ";
			}
			return flag;
			
		}
	}	
}
class People{
  	String name;
  	String sex;
	String byear;
	String bmonth;
	String bday;
	public People(String name, String sex, String bday) {
		String[] birthday=bday.split("/");
		this.name = name;
		this.sex = sex;
		this.byear = birthday[0];
		this.bmonth = birthday[1];
		this.bday = birthday[2];
	}	
}

class Reader {
	static BufferedReader reader; 
	static StringTokenizer tokenizer;

   static void init(InputStream input) { 
	   reader = new BufferedReader( new InputStreamReader(input) ); 
	   tokenizer = new StringTokenizer(""); }

   static String next() throws IOException { 
    	   while ( ! tokenizer.hasMoreTokens()) 
    	   { tokenizer = new StringTokenizer( reader.readLine() );
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