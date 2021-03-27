package mathPbs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MemoryAllocation {
  static  int[] memory;
  static  int[] need;
  static Scanner sc=new Scanner(new BufferedInputStream(System.in));
	public static void main(String[] args) {
		
        int freq=sc.nextInt();
        int[][] ends=new int[freq][];
        for(int i=0;i<freq;i++) {
        	setArrs(sc.nextInt(),1);
        	setArrs(sc.nextInt(),0);
        	ends[i]=setrs();

        }
        for(int i=0;i<freq;i++) {
        	
        	for(int j=0;j<ends[i].length;j++) {
        		if(j==0) {
        			if(ends[i][j]==-1) {
            			System.out.print("NULL");
            		}else {
            			System.out.print(ends[i][j]);
            		}

        		}else {
        		if(ends[i][j]==-1) {
        			System.out.print(" NULL");
        		}else {
        			System.out.print(" "+ends[i][j]);
        		}

        	}
        	}	
            System.out.println();        	       	
        }          
        sc.close();   
	}

	
	public static void setArrs(int size,int flag) {
		if(flag==1) {
			memory=new int[size];
		for(int i=0;i<size;i++) 
			memory[i]=sc.nextInt();			
		
		}else {
			need=new int[size];
			for(int i=0;i<size;i++) 
			need[i]=sc.nextInt();	

		}
	}
    public static int[] setrs() {
    	Arrays.sort(memory);
    	for(int i=0;i<need.length;i++) {
    		if(need[i]>memory[memory.length-1]) {
    		   need[i]=-1;
    		}else {
    			for(int j=0;j<memory.length;j++) {
    				if(memory[j]>=need[i]) {
    				    need[i]=memory[j];
    				    memory[j]=0;
    				    Arrays.sort(memory);
    				    break;
    				}
    			}
    			
    		}
    	}
    	
    	return need;
    }
	
}
