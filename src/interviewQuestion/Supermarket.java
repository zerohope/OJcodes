package interviewQuestion;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            PriorityQueue<good> minHeap = new PriorityQueue<>((g1, g2) -> g1.day - g2.day);
            PriorityQueue<good> res = new PriorityQueue<>((g1, g2) -> g1.price - g2.price);
            for (int i = 0; i < N; i++) {
                minHeap.offer(new good(sc.nextInt(), sc.nextInt()));
            }
            while (!minHeap.isEmpty()) {
                if (res.size() < minHeap.peek().day) {
                    res.offer(minHeap.poll());
                } else {
                    if (res.peek().price > minHeap.peek().price) {
                        minHeap.poll();
                    } else {
                        res.poll();
                        res.offer(minHeap.poll());
                    }
                }
            }
            int pt = 0;
            while (!res.isEmpty()) {
                pt += res.poll().price;
            }
            System.out.println(pt);
        }

    }

}
class good{
    int price;
    int day;
    public good(int p,int d){
        this.price=p;
        this.day=d;

    }
    }