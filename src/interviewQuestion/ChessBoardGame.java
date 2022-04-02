package interviewQuestion;

import java.util.*;

public class ChessBoardGame {
    static int N=4;
    static String start,end;
    static Map<String,Integer> dis=new HashMap<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        start="";
        for(int i=0;i<N;i++) start+=sc.next();
        end="";
        for(int i=0;i<N;i++) end+=sc.next();
        bfs();


    }
    public static void bfs(){
        if(start.equals(end)) {
            System.out.println(0);
        return ;
        }
        Queue<String> q=new LinkedList<>();
        dis.put(start,0);
        q.offer(start);
        while(!q.isEmpty()){
            String temp=q.poll();
            char[] chess=temp.toCharArray();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=0;k<4;k++){
                        int x_n=i+dx[k],y_n=j+dy[k];
                        if(x_n>=0&&x_n<N&&y_n>=0&&y_n<N){
                            swap(chess,i*N+j,x_n*N+y_n);
                            String cs=new String(chess);
                            if(cs.equals(end)){
                                System.out.println(dis.get(temp)+1);
                                return;
                            }
                            if(!dis.containsKey(cs)) {
                                dis.put(cs, dis.get(temp) + 1);
                                q.offer(cs);
                            }
                            chess=temp.toCharArray();
                        }

                    }


                }


            }

        }


    }
public static void swap(char[] c,int x,int nx){
        char temp=c[x];
        c[x]=c[nx];
        c[nx]=temp;

}


}
