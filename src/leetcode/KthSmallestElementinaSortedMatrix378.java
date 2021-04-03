package leetcode;

public class KthSmallestElementinaSortedMatrix378 {
    public static int kthSmallest(int[][] matrix, int k) {
        int start=matrix[0][0],end=matrix[matrix.length-1][matrix.length-1];
        //什么时候可以加等号？
        while(start<=end){
            int mid=(start+end)/2;
            int[] pair=new int[]{start,end};
            int count=countSmall(mid,matrix,pair);
            if(count==k)
                return pair[0];
            if(count<k)
                start=pair[1];
            else
                end=pair[0];
        }
        return start;
    }
    public static int countSmall(int mid, int[][] matrix,int[] pair){
        int row=matrix.length-1,col=0,count=0;
        while(row>=0&&col<=matrix.length-1){
            if(matrix[row][col]<=mid){
                pair[0]=Math.max(pair[0],matrix[row][col]);
                count+=row+1;
                col++;
            }else{
                pair[1]=Math.min(pair[1],matrix[row][col]);
                row--;
            }
        }

    return count;

    }

public static void main(String[] args){
    kthSmallest(new int[][]{new int[]{1,2},new int[]{1,3}},1);

}

}
