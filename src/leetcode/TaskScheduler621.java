package leetcode;

import java.util.*;

public class TaskScheduler621 {
    public static int leastInterval(char[] tasks, int n){
        int res=0,flag=0;
        Map<Character,Integer> cf=new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>>maxHeap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(char c:tasks)
            cf.put(c,cf.getOrDefault(c,0)+1);
        List<Map.Entry<Character,Integer>> list=new ArrayList<>();
        maxHeap.addAll(cf.entrySet());
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> cur=maxHeap.poll();
           // System.out.print(cur.getKey()+"---");
            res++;
            flag++;
            cur.setValue(cur.getValue()-1);
            if(flag==tasks.length)
                break;
            list.add(cur);
            if(list.size()==n+1){
                Map.Entry<Character,Integer> entry=list.get(0);
                list.remove(0);
                if(entry.getValue()>0)
                maxHeap.offer(entry);
            }
            if(maxHeap.isEmpty()&&!list.isEmpty()){
                while(!list.isEmpty()) {
                    Map.Entry<Character, Integer> entry = list.get(0);
                    list.remove(0);
                    if(entry.getValue()>0){
                        list.add(0,entry);
                        break;
                    }
                }
                res+=n-list.size()+1;
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getValue()>0)
                    maxHeap.offer(list.get(i));
                }
                list.clear();
            }

        }


    return res;

    }
public static void main(String[] args){

    System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},2));

}

}
