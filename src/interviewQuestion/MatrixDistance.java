package interviewQuestion;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Coordina{
  int x;
  int y;
    Coordina(int x, int y){
      this.x=x;
      this.y=y;
  }
}
public class MatrixDistance {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int[][] A=new int[m][n];
        int[][] B=new int[m][n];
        Queue<Coordina> q=new LinkedList<>();
        for(int i=0;i<m;i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                A[i][j] = tmp.charAt(j)-'0';
                if(A[i][j]==1) {
                    B[i][j] = 0;
                    q.offer(new Coordina(i,j));
                } else
                 B[i][j]=-1;
            }
        }
        int[] dx=new int[]{-1,0,1,0};
        int[] dy=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
                       Coordina c=q.poll();
                for(int j=0;j<4;j++){
                    int x=c.x+dx[j],y=c.y+dy[j];
                    if(x>=0&&x<m&&y>=0&&y<n){
                            if(A[x][y]==0&&B[x][y]==-1){
                                B[x][y]=B[c.x][c.y]+1;
                                q.offer(new Coordina(x,y));
                            }

                    }

                }
        }
        //直接输出会超时
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(B[i][j] + " ");
            }
            System.out.println(sb.toString());
        }

    }



    public static void test(String[] args){
     Scanner sc=new Scanner(System.in);
        int[][] A=new int[sc.nextInt()][sc.nextInt()];
        int[][] B=new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++) {
            String nbs = sc.next();
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = nbs.charAt(j)-'0';
            }
        }
        for(int i=0;i<A.length;i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[i][j] = bfs(A, i, j);
                System.out.print(B[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static int bfs(int[][] A, int x, int y){
        int[] add=new int[]{1,-1};
        int rs=0;
        if(A[x][y]==1)
            return rs;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y});
        while(!q.isEmpty()) {
            int size=q.size();
            rs++;
            for(int s=0;s<size;s++) {
                int[] cood=q.poll();
                for (int j = 0; j < 2; j++){
                    if(cood[0]+add[j]>=0&&cood[0]+add[j]< A.length){
                            if(A[cood[0]+add[j]][cood[1]]==1)
                                return rs;
                            q.offer(new int[]{cood[0]+add[j],cood[1]});
                    }
                }
                for (int j = 0; j < 2; j++){
                    if(cood[1]+add[j]>=0&&cood[1]+add[j]< A[0].length){
                        if(A[cood[0]][cood[1]+add[j]]==1)
                            return rs;
                        q.offer(new int[]{cood[0],cood[1]+add[j]});
                    }
                }

            }

        }
        return -1;
    }
}
