package leetcode;

import java.util.*;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        int idx=0;
        if(numCourses<=0)
            return res;
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
            inDegree.put(edge[0],inDegree.get(edge[0])+1);
            children.get(edge[1]).add(edge[0]);
        }
        for(Map.Entry<Integer,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                curNode.offer(entry.getKey());
        }
        while(!curNode.isEmpty()){
            res[idx++]=curNode.peek();
            List<Integer> curChildren=children.get(curNode.poll());
            for(int child:curChildren){
                int degree=inDegree.get(child)-1;
                inDegree.put(child,degree);
                if(degree==0)
                    curNode.offer(child);
            }
        }
        if(idx!=numCourses)
            return new int[numCourses];
        return res;
    }
}
