package GrokkingCoding;

import java.util.*;

public class AllTasksSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites){
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> inDegree=new HashMap<>();
        Map<Integer, List<Integer>> graph=new HashMap<>();
        Queue<Integer> cur=new LinkedList<>();
        for(int i=0;i<tasks;i++){
            inDegree.put(i,0);
            graph.put(i,new ArrayList<>());
        }
        for(int[] require:prerequisites){
            inDegree.put(require[1],inDegree.get(require[1])+1);
            graph.get(require[0]).add(require[1]);
        }
        for(Map.Entry<Integer,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                cur.offer(entry.getKey());
        }
        findOrder(inDegree,graph,res,cur);
    }
    public static void findOrder(Map<Integer,Integer> inDegree, Map<Integer,List<Integer>> graph,List<Integer> res,Queue<Integer> source){
            if(!source.isEmpty()) {
                for (Integer currentSource : source) {
                    res.add(currentSource);
                    Queue<Integer> sourceForNextOrder = copyQueue(source);
                    sourceForNextOrder.remove(currentSource);
                    for (Integer node : graph.get(currentSource)) {
                        inDegree.put(node, inDegree.get(node) - 1);
                        if (inDegree.get(node) == 0)
                            sourceForNextOrder.offer(node);
                    }
                    findOrder(inDegree,graph,res,sourceForNextOrder);
                    res.remove(currentSource);
                    for (Integer node : graph.get(currentSource)) {
                        inDegree.put(node, inDegree.get(node) + 1);
                    }
                }
            }
            if(res.size()==inDegree.size())
                System.out.println(res.toString());
    }
    public static Queue<Integer> copyQueue(Queue<Integer> q){
        Queue<Integer> temp=new LinkedList<>();
        for(Integer source:q){
            temp.offer(source);
        }
        return temp;
    }
    public static void main(String[] args){
        printOrders(6,new int[][]{new int[]{2,5},new int[]{0,5},new int[]{0,4},new int[]{1,4},new int[]{3,2},new int[]{1,3}});


    }
}
