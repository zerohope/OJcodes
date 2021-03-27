package TreePbs;

import java.io.BufferedInputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FindTreasure {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int nodes=sc.nextInt();
		sc.nextInt();
		int ts=sc.nextInt();
		TrNode[] tn=new TrNode[nodes];
		for(int i=0;i<nodes;i++)
			tn[i]=new TrNode(0);
		tn[0].father=-1;
		for(int i=0;i<nodes-1;i++) {
			int father=sc.nextInt();
			int son=sc.nextInt();
			tn[son].father=father;
			tn[father].cNumber+=1;
		}
		findTs(tn,ts);
		
        sc.close();
	}
      public static void findTs(TrNode[] tr, int ts) {
    	  TrNode node=tr[ts];
    	  int branch=1;
    	  while(node.father!=-1) {
    		  node=tr[node.father];
    		  if(node.cNumber>1) {
    		  branch*=node.cNumber;
    		  }
    	  }

    	  if(branch==0) {
    		System.out.println("1.000000");  
    	  }else {
    		  
    	  //格式化小数，并保证四舍五入
    	  DecimalFormat  df=new DecimalFormat ("#0.000000");
    	  df.setRoundingMode(RoundingMode.HALF_UP);
    	  double rs=1/(double)branch;
    	  System.out.println(df.format(rs));
    	  
    	  
    	  }
      }
}
class TrNode{
	public int cNumber;
	public int father;
	public TrNode(int f) {
		this.father=f;
		this.cNumber=0;
	}
	
	
}