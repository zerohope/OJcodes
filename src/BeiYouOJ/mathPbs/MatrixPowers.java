package mathPbs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class MatrixPowers {

	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int tms=sc.nextInt();
		while(tms>0) {
			int n=sc.nextInt();
			int b=sc.nextInt();
			int[][] mar=new int[n][n];
			for(int i=0;i<n;i++)
			  for(int j=0;j<n;j++)
				  mar[i][j]=sc.nextInt();
			    fastPower(mar,b);
			          tms--;	
		}
		
        sc.close();
	}
	//快速幂做矩阵的幂
	public static void fastPower(int[][] mar, int n) {
		int size=mar.length;
		int[][] ans=new int[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(i==j)
			      ans[i][j]=1;
		while(n!=0) {
			if((n&1)!=0)
			  ans=multi(ans,mar);
			mar=multi(mar,mar);
			n=n>>1;
		}
		for(int i=0;i<size;i++) {
		    for(int j=0;j<size;j++) {
		    	if(j==size-1) {
		    	 System.out.print(ans[i][j]);
		    	}else {
		    	System.out.print(ans[i][j]+" ");
		    	}
		    }
		   System.out.println("");
		}
	}//矩阵相乘
	public static int[][] multi(int[][] A, int[][] B) {
	int[][] C=new int[A.length][B[0].length];
		for(int i=0;i<A.length;i++)
		  for(int j=0;j<B[0].length;j++)
		    for(int k=0;k<A[0].length;k++)
		      C[i][j]+=A[i][k]*B[k][j];
		       return C;
	}
	

}
