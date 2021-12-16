package interviewQuestion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point{
    int x;
    int y;
    public Point(int a,int b){
        this.x=a;
        this.y=b;
    }
}
public class MovingKnight {
    static int[][] map=new int[310][310];
    static int M=0;
    static boolean[][] check=new boolean[310][310];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n>0){
            M=sc.nextInt();
            Point st=new Point(sc.nextInt(),sc.nextInt());
            Point ed=new Point(sc.nextInt(),sc.nextInt());
            st.x=++st.x;st.y=++st.y;
            ed.x=++ed.x;ed.y=++ed.y;
            System.out.println(BFS(st,ed));
            map=new int[310][310];
            check=new boolean[310][310];
            n--;
        }

    }
    public static int BFS(Point st,Point ed){
        int[] dx={-2,-2,-1,-1,1,1,2,2};int[] dy={1,-1,2,-2,2,-2,1,-1};
        Queue<Point> q=new LinkedList<>();
        check[st.x][st.y]=true;
        q.offer(st);
        int res=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Point temp=q.poll();
                int x= temp.x,y=temp.y;
                if(x==ed.x&&y==ed.y)
                    return res;
                else{
                    for(int j=0;j<8;j++){
                        int tx=x+dx[j];
                        int ty=y+dy[j];
                        if(tx>=1&&tx<=M){
                            if(ty>=1&&ty<=M)
                                if(!check[tx][ty]) {
                                    q.offer(new Point(tx, ty));
                                    check[tx][ty]=true;
                                }
                        }
                    }
                }

            }
            res++;
        }
        return -1;
    }


}
