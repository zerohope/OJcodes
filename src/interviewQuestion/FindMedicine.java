package interviewQuestion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node{
    int x;
    int y;
    public Node(int a,int b){
        this.x=a;
        this.y=b;
    }
}
public class FindMedicine {
    static char[][] fields=new char[310][310];
    static int M;
    static int N;
    static boolean[][] visit=new boolean[310][310];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            M = sc.nextInt();
            N = sc.nextInt();
            if(M==0&&N==0)
                break;
            Node st=new Node(0,0);
            for (int i = 0; i < M; i++) {
                fields[i] = sc.next().toCharArray();
                for (int j = 0; j < N; j++) {
                    if(fields[i][j]=='@') {
                        st.x=i;st.y=j;
                    }
                }

            }
            System.out.println(BFS(st));
            visit=new boolean[310][310];
        }
    }
public static int BFS(Node n){
        int[] dx={0,0,-1,1};int[] dy={1,-1,0,0};
    Queue<Node> q=new LinkedList<>();
      visit[n.x][n.y]=true;
      q.offer(n);
      int res=0;
      while(!q.isEmpty()){
          int size=q.size();
          for(int i=0;i<size;i++){
            Node temp=q.poll();
            char c=fields[temp.x][temp.y];
            if(c=='*'){
                return res++;
            }else if(c=='#') {
                continue;
            }else{
                for(int j=0;j<4;j++){
                    int tx=temp.x+dx[j];
                    int ty=temp.y+dy[j];
                    if(tx>=0&&tx<M){
                        if(ty>=0&&ty<N)
                            if(!visit[tx][ty]) {
                                q.offer(new Node(tx, ty));
                                visit[tx][ty]=true;
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
