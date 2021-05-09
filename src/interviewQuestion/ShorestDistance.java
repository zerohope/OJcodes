package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShorestDistance {
    static class Edge{
        int x,y,d;
        public Edge(int a, int b, int c){
            x=a;
            y=b;
            d=c;
        }
    }
    static final int INF = Integer.MAX_VALUE >> 1;
    static int n,m;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] st;
    public static void main(String[] args) throws Exception{
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String[] s = cin.readLine().split("\\s+");
        n = Integer.parseInt(s[0])+1;
        m = Integer.parseInt(s[1]);
        st = new boolean[n];
        dist = new int[n];
        for( int i=0;i<n;i++)
            graph.add(new ArrayList<Edge>());
        while (m-->0) {
            String[] s1 = cin.readLine().split("\\s+");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int z = Integer.parseInt(s1[2]);
            graph.get(x).add(new Edge(x, y, z));
            graph.get(y).add(new Edge(y, x, z));
        }
        String shop=cin.readLine();
        int shopNb=Integer.parseInt(shop);
        while(shopNb-->0){
            int x=0;
            int y=Integer.parseInt(cin.readLine());
            int z=0;
            graph.get(x).add(new Edge(x, y, z));
        }
        int[] res=spfa();
        int query=Integer.parseInt(cin.readLine());
        while(query-->0){
            System.out.println(res[Integer.parseInt(cin.readLine())]);
        }

    }

    static int[] spfa(){
        Arrays.fill(dist, INF);
        dist[0]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        st[0]=true;
        while(!q.isEmpty()){
            int x = q.poll();
            st[x] = false;
            List<Edge> edges = graph.get(x);
            for (int i = 0 ; i < edges.size(); i ++){
                Edge edge = edges.get(i);
                int y = edge.y;
                if (dist[y] > dist[x] + edge.d ){
                    dist[y] = dist[x] + edge.d;
                    if(!st[y]){
                        q.add(y);
                        st[y] = true;
                    }
                }
            }
        }
        return dist;

    }



}
