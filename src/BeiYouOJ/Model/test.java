package Model;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maximalSquare(new char[][] {{'1'}}));
	}
	
	public static int maximalSquare(char[][] matrix) {
		if(matrix.length==0) {
			return 0;
		}
        int[][] a=new int[matrix.length][matrix[0].length];
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                a[i][j]=(int)matrix[i][j]-'0';
            }
        }
        int rs=0;
	   int temp[][]=new int[a.length][a[0].length];
	   for(int i=0;i<a.length;i++)
		   temp[i][0]=a[i][0];
	   for(int i=0;i<a[0].length;i++)
		   temp[0][i]=a[0][i];
	   for(int i=1;i<a.length;i++)
           for(int j=1;j<a[0].length;j++) {
        	   if(a[i][j]==1) {
        		   temp[i][j]=Math.min(Math.min(temp[i-1][j],temp[i][j-1]), temp[i-1][j-1])+1;
        	   }
           }
	   for(int i=0;i<a.length;i++)
           for(int j=0;j<a[0].length;j++) {
        	   if(temp[i][j]>rs)
          	     rs=temp[i][j];
           }
           
        return rs*rs;
    }
}
