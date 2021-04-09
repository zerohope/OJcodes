package leetcode;

import java.util.*;

public class MinimumHeightTrees210 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int min=n;
        List<Integer> res=new ArrayList<>();
        int[] visit=new int[n];
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Map<Integer,Integer> length=new HashMap<>();
        Queue<Integer> cur=new LinkedList<>();
        for(int i=0;i<n;i++){
          graph.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            List<Integer> children=graph.get(i);
            int temp=0;
            visit[i]=1;
            for(Integer c:children){
                cur.offer(c);
                visit[c]=1;
            }
            temp++;
            while(!cur.isEmpty()){
                int size=cur.size();
                for(int j=0;j<size;j++){
                    List<Integer> node=graph.get(cur.poll());
                    for(Integer c:node){
                        if(visit[c]!=1) {
                            cur.offer(c);
                            visit[c] = 1;
                        }
                    }
                }
                temp++;
            }
            length.put(i,temp);
            min=Math.min(temp,min);
            for(int k=0;k<visit.length;k++)
                visit[k]=0;
        }
        for(Map.Entry<Integer,Integer> entry:length.entrySet()){
            if(entry.getValue()==min)
                res.add(entry.getKey());
        }
        return res;
    }

    public static List<Integer> pruning(int n, int[][] edges){
        List<Integer> res=new ArrayList<>();
        if(n<=0)
            return res;
        if(n==1) {
            res.add(0);
            return res;
        }
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Map<Integer,Integer> inDegree=new HashMap<>();
        Queue<Integer> cur=new LinkedList<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
            inDegree.put(i,0);
        }
        for(int[] edge:edges){
            inDegree.put(edge[0],inDegree.get(edge[0])+1);
            inDegree.put(edge[1],inDegree.get(edge[1])+1);
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(Map.Entry<Integer,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==1)
                cur.offer(entry.getKey());
        }
        int totalNodes=n;
        while(totalNodes>2){
          int leaveSize=cur.size();
          totalNodes-=leaveSize;
          for(int i=0;i<leaveSize;i++){
              int vertex=cur.poll();
              List<Integer> children=graph.get(vertex);
              for(int child:children){
                  int degree=inDegree.get(child)-1;
                  inDegree.put(child,degree);
                  if(degree==1)
                      cur.offer(child);
              }
          }
        }
        res.addAll(cur);
        return res;
    }
    public static void main(String[] args){
        System.out.println(pruning(4,new int [][]{new int[]{1,0},new int[]{1,2},new int[]{1,3}}));
    }

}
