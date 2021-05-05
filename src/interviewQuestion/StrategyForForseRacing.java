package interviewQuestion;

import java.util.*;

public class StrategyForForseRacing {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            if(count==0){
                continue;
            }
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            for(int i=0;i<count;i++)
                list1.add(sc.nextInt());
            for(int i=0;i<count;i++)
                list2.add(sc.nextInt());
            Collections.sort(list1,Collections.reverseOrder());
            Collections.sort(list2,Collections.reverseOrder());
            int win=0,lost=0;
            while(list1.size()>0&&list2.size()>0){
                if(list1.get(list1.size()-1)>list2.get(list2.size()-1)){
                    list1.remove(list1.size()-1);
                    list2.remove(list2.size()-1);
                    win++;
                }
                else if(list1.get(list1.size()-1)<list2.get(list2.size()-1)){
                    list1.remove(list1.size()-1);
                    list2.remove(0);
                    lost++;

                }
                else if(list1.get(0)>list2.get(0)){
                    list1.remove(0);
                    list2.remove(0);
                    win++;

                }
                else if(list1.get(0)<list2.get(0)){
                    list1.remove(list1.size()-1);
                    list2.remove(0);
                    lost++;

                } else{
                    if(list2.get(0)>list1.get(list1.size()-1))
                        lost++;
                    list1.remove(list1.size()-1);
                    list2.remove(0);

                }
            }
            if (win > lost)
                System.out.println(200*(win-lost));
            else if (win < lost)
                System.out.println(-200*(lost-win));
            else
                System.out.println(0);

        }
    }


    //考虑用两个最大堆解决问题，失败了
    //没有办法判断平局
    public static void test() {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>((a1, a2) -> a2 - a1);
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((a1, a2) -> a2 - a1);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            if(count==0){
                continue;
            }
            for (int i = 0; i < count; i++)
                maxHeap1.offer(sc.nextInt());
            for (int i = 0; i < count; i++)
                maxHeap2.offer(sc.nextInt());
            int win = 0, lost = 0;
            while (!maxHeap1.isEmpty() && !maxHeap2.isEmpty()) {
                if (maxHeap1.peek() < maxHeap2.peek()) {
                    maxHeap2.poll();
                    lost++;
                } else if (maxHeap1.peek() == maxHeap2.peek()) {
                    maxHeap2.poll();
                } else if (maxHeap1.peek() > maxHeap2.peek()) {
                    maxHeap1.poll();
                    maxHeap2.poll();
                    win++;
                }
            }
            if (win > lost)
                System.out.println(200*(win-lost));
            else if (win < lost)
                System.out.println(-200*(lost-win));
            else
                System.out.println(0);
            maxHeap1.clear();
            maxHeap2.clear();
        }


    }





}
