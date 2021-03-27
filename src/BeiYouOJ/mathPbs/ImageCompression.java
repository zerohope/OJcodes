package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class ImageCompression {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int length=sc.nextInt();
		int[][] a=new int[length][length];
		int [][] b=new int[length][length];
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
            	a[i][j]=sc.nextInt();
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
            	b[i][j]=sc.nextInt();
       
        findMatrix(createMatrix(a,b));
        
	}
//求两个矩阵中最大的相同正方形（先异或，在创建面积矩阵）	
   public static int[][] createMatrix(int[][] a,int[][] b) {
	   int[][] c=new int[a.length][a.length];
	   for(int i=0;i<c.length;i++)
           for(int j=0;j<c.length;j++)
	            if(a[i][j]==b[i][j])
	            	c[i][j]=1;
	                return c;
   }
   public static void findMatrix(int[][] a) {
	   int rs=0;
	   int temp[][]=new int[a.length][a.length];
	   for(int i=0;i<a.length;i++)
		   temp[i][0]=a[i][0];
	   for(int i=0;i<a.length;i++)
		   temp[0][i]=a[0][i];
	   for(int i=1;i<a.length;i++)
           for(int j=1;j<a.length;j++) {
        	   if(a[i][j]==1) {
        		   temp[i][j]=Math.min(Math.min(temp[i-1][j],temp[i][j-1]), temp[i-1][j-1])+1;
        	   }
        	   if(temp[i][j]>rs)
        	     rs=temp[i][j];
           }
	   System.out.println(rs);
   }
   
}
