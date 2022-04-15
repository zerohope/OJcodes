package leetcode;


import java.util.*;

public class JumpGame1345 {
   static boolean[] visited;
   public static void main(String[] args){


       System.out.println(minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));

   }
    public static int minJumps(int[] arr) {
        visited=new boolean[arr.length];
        Map<Integer, List<Integer>> memory=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> integers = memory.get(arr[i]);
            if (integers == null) {
                integers = new ArrayList<>();
                memory.put(arr[i], integers);
            }
            integers.add(i);
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        int res=0;
        while (!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++) {
                int cidx = q.poll();
                if (cidx == arr.length - 1)
                    return res;
                visited[cidx] = true;
                if (cidx + 1 < arr.length && !visited[cidx + 1]) {
                    q.offer(cidx + 1);
                }
                if (cidx - 1>=0 && !visited[cidx - 1]) {
                    q.offer(cidx - 1);
                }
                List<Integer> obj=memory.get(arr[cidx]);
                if(obj!=null)
                for(int idx:obj){
                    if(!visited[idx])
                        q.offer(idx);
                }
                memory.remove(arr[cidx]);
            }
            res++;

        }
            return -1;
    }

}
