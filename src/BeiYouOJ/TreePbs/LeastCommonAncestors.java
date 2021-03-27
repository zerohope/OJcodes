package TreePbs;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeastCommonAncestors {

 	public static void main(String[] args) {
  		Scanner sc=new Scanner(new BufferedInputStream(System.in));
	    int tms=sc.nextInt();
	    int[] tree = null;
	    List<Integer> ends=new ArrayList<Integer>();
	    for(int i=0;i<tms;i++) {
	    	tree=new int[sc.nextInt()+1];
	    	tree=initTree(tree);
	        for(int j=0;j<tree.length-2;j++) {
	        	int father=sc.nextInt();
	        	int child=sc.nextInt();
	        	tree[child]=father;
	        }
	        int lg=sc.nextInt();
	    	for(int k=0;k<lg;k++) {
	    		ends.add(tirmTree(tree,sc.nextInt(),sc.nextInt()));
	    	}
	    	
	    }
		for(int i=0;i<ends.size();i++) {
		        System.out.println(ends.get(i));
		}	
	}

 	public static int[] initTree(int[] tr) {
 		tr[0]=0;
 		for(int i=1;i<tr.length;i++)
 		 tr[i]=-1;
 		return tr;
 		
 	}
 	public static int tirmTree(int[] tree,int a, int b) {
        int ha=0, hb=0,temp=a;
         
 		while(tree[temp]!=-1) {	
           ha++;
           temp=tree[temp];
 		}
 		temp=b;
 		while(tree[temp]!=-1) {
 	       hb++;       
 	      temp=tree[temp];
 		}
 	while(ha-hb>1) {
 		a=tree[a];
 		ha--;
 	}
	while(hb-ha>1) {
 		b=tree[b];
 		hb--;
 	}	
	if(ha>hb) {
		return findPr(tree, a,b,ha,hb);
	}	
 		return findPr(tree, b,a,hb,ha);
 	}
 	
 	public static int findPr(int[]tr, int a, int b, int ha, int hb) {
 		  if(a==b) {
 	    	  return a;
 	      }
 	      if(ha>hb) {
 	    	  if(b==tr[a]) {
 	    		  return b;
 	    		  }
 	    	  else {
 	    		  a=tr[a];
 	    		  ha--;
 	    	  }	  
 	      }
 	     for(;ha>0;ha--) {
  			if(tr[a]==tr[b]) {
  				return tr[a];
  			}else {
  				a=tr[a];
  				b=tr[b];
  			}
  		}
    
 		
 		return 0;
 	}
 	
}

