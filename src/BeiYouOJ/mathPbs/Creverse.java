package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Creverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int[][] matrix=new int[5][5];
        for(int i=0;i<5;i++)
        	for(int j=0;j<5;j++)
        		matrix[i][j]=sc.nextInt();
         int[] ops=new int[] {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
           opMatrix(matrix,ops); 
	} 
    public static void opMatrix(int[][] m, int[]op) {
    	switch (op[0]) {
		case 1:
       if(op[1]==2) {
       m=reverse(m,op[2]-1,op[3]-1,2);
       }else {
        m=reverse(m,op[2]-1,op[3]-1,3);  
       }
			break;
         case 2:
        if(op[1]==2) {
        m=reverse(m,op[2]-1,op[3]-1,2);
        m=reverse(m,op[2]-1,op[3]-1,2);
        m=reverse(m,op[2]-1,op[3]-1,2);
           }else {
        	  m=reverse(m,op[2]-1,op[3]-1,3);
        	  m=reverse(m,op[2]-1,op[3]-1,3); 
        	  m=reverse(m,op[2]-1,op[3]-1,3); 
        	 }
			break;		
		default:
			break;
		} 
    	
    	 for(int i=0;i<5;i++) {
         	for(int j=0;j<5;j++) {
         		if(j==4){
         		  System.out.print(m[i][j]);
         	}else {
         		System.out.print(m[i][j]+" ");
         		}
         	}
    	  System.out.println("");
    	 }
    	
    }
    
    public static int[][] reverse(int[][] m, int x,int y,int lth) {
    	int[][] temp=new int[lth][lth];
    	for(int i=0;i<lth;i++)
    	  for(int j=0;j<lth;j++)
    	     temp[i][j]=m[x+i][y+j];  
    	for(int i=0;i<lth;i++)
      	  for(int j=0;j<lth;j++)
    	    m[x+j][y+lth-i-1]=temp[i][j];
    	
    	     return m;
    }
}
