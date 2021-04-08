package leetcode;

import java.util.*;

public class AlienDictionary269 {
    public String alienOrder(String[] words) {
        Map<Character,Integer> inDegree=new HashMap<>();
        Map<Character, List<Character>> graph=new HashMap<>();
        Queue<Character> curNode=new LinkedList<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                inDegree.put(c,0);
                graph.put(c,new ArrayList<>());
            }
        }
        for(int i=0;i<words.length-1;i++){
          String w1=words[i],w2=words[i+1];
            for(int j=0;j<Math.min(w1.length(),w2.length());j++) {
                char parent=w1.charAt(j),child=w2.charAt(j);
                if(parent!=child){
                    graph.get(parent).add(child);
                    inDegree.put(child,inDegree.get(child)+1);
                }
            }
        }
        for(Map.Entry<Character,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                curNode.offer(entry.getKey());
        }
        StringBuilder sort=new StringBuilder(inDegree.size());
        while(!curNode.isEmpty()){
            sort.append(curNode.peek());
            List<Character> curChildren=graph.get(curNode.poll());
            for(char child:curChildren){
                int degree=inDegree.get(child)-1;
                inDegree.put(child,degree);
                if(degree==0)
                    curNode.offer(child);
            }
        }
        if(sort.length()!=inDegree.size())
            return "";
        return sort.toString();


    }

}
