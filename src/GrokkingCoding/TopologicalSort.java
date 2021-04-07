package GrokkingCoding;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges){
        List<Integer> sort=new ArrayList<>();
        //记录每个节点的入度
        Map<Integer,Integer> inDegree=new HashMap<>();
        //记录每个节点的子节点
        Map<Integer,List<Integer>> children=new HashMap<>();
        Queue<Integer> curNode=new LinkedList<>();
        for(int i=0;i<vertices;i++){
            inDegree.put(i,0);
            children.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            inDegree.put(edge[1],inDegree.get(edge[1])+1);
            children.get(edge[0]).add(edge[1]);
        }
        for(Map.Entry<Integer,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                curNode.offer(entry.getKey());
        }
        while(!curNode.isEmpty()){
            sort.add(curNode.peek());
            List<Integer> curChildren=children.get(curNode.poll());
            for(int child:curChildren){
                int degree=inDegree.get(child)-1;
                inDegree.put(child,degree);
                if(degree==0)
                    curNode.offer(child);
            }
        }
        if(sort.size()!=vertices)
            return new ArrayList<>();
        return sort;
    }
        public static void main(String[] args){
            System.out.println(sort(4,new int[][] {new int[]{3,2},new int[]{3,0},new int[]{2,0},new int[]{2,1}}));


        }

}
