package leetcode;

import java.util.*;

public class RearrangeStringkDistanceApart358 {
    public static String reorganizeString(String s, int k){
        if(k<=1)
            return s;
     Map<Character,Integer> cf=new HashMap<>();
     PriorityQueue<Map.Entry<Character,Integer>> maxHeap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
     for(char c:s.toCharArray())
         cf.put(c,cf.getOrDefault(c,0)+1);
     maxHeap.addAll(cf.entrySet());
     Queue<Map.Entry<Character,Integer>> eq=new LinkedList<>();
     StringBuilder res=new StringBuilder(s.length());
     while(!maxHeap.isEmpty()){
         Map.Entry<Character,Integer> cur=maxHeap.poll();
         res.append(cur.getKey());
         cur.setValue(cur.getValue()-1);
         //先加入队列，加入堆中在判空，为什么？
         eq.offer(cur);
         if(eq.size()==k) {
             Map.Entry<Character,Integer> entry=eq.poll();
             if(entry.getValue()>0)
                 maxHeap.add(entry);
         }
     }

    return res.length()==s.length()?res.toString():"";
    }





    public static void main(String[] args){

        reorganizeString("aabbcc",3);




    }


}
