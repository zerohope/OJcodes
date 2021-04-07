package leetcode;

import java.util.*;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //List<Integer> sort=new ArrayList<>();
        int canFin=0;
        if(numCourses<=0)
            return false;
        //记录每个节点的入度
        Map<Integer,Integer> inDegree=new HashMap<>();
        //记录每个节点的子节点
        Map<Integer,List<Integer>> children=new HashMap<>();
        Queue<Integer> curNode=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            inDegree.put(i,0);
            children.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:prerequisites){
            inDegree.put(edge[1],inDegree.get(edge[1])+1);
            children.get(edge[0]).add(edge[1]);
        }
        for(Map.Entry<Integer,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                curNode.offer(entry.getKey());
        }
        while(!curNode.isEmpty()){
            canFin++;
            List<Integer> curChildren=children.get(curNode.poll());
            for(int child:curChildren){
                int degree=inDegree.get(child)-1;
                inDegree.put(child,degree);
                if(degree==0)
                    curNode.offer(child);
            }
        }
        if(canFin!=numCourses)
            return false;
        return true;
    }
}
