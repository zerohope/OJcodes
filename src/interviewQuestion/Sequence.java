package interviewQuestion;

import java.util.*;

public class Sequence {
    static int N = 2010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];
    static int n;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        String res="";
        while(T--!=0){
            int m=sc.nextInt();
            n= sc.nextInt();
            for(int i=0;i<n;i++)
              a[i]=sc.nextInt();
            Arrays.sort(a, 0, n);
            for (int i = 0; i < m - 1; i ++){
                for (int j = 0; j < n; j ++){
                    b[j] = sc.nextInt();
                }
                merge(a, b);
            }
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < n; i ++){
                str.append(a[i]+" ");
            }
            System.out.println(str);

        }


    }
    static void merge(int[] a, int[] b){
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((x,y)->x[0]-y[0]);
        for(int i=0;i<n;i++){
            minHeap.offer(new int[]{a[0]+b[i],0,i});
        }
        for(int i=0;i<n;i++){
            int[] temp=minHeap.poll();
            c[i]=temp[0];
            int x=temp[1];
            int y=temp[2];
            minHeap.offer(new int[]{a[x+1]+b[y],x+1,y});
        }
        for (int i = 0; i < n; i ++){
            a[i] = c[i];
        }
    }



    //前缀和求解，出错 反例: 123 456
    public static void wrongTest(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        String res="";
        while(T>0){
            int m=sc.nextInt(),n= sc.nextInt();
            int[] idx=new int[m];
            Arrays.fill(idx,1);

            int[][] nums=new int[m][n];
            for(int i=0;i<m;i++) {
                int[] temp=new int[n];
                for (int j = 0; j < n; j++) {
                    temp[j] = sc.nextInt();
                }
                Arrays.sort(temp);
                nums[i]=temp;
            }
            if(n==1){
                int count=0;
                for(int i=0;i<m;i++) {
                    count+=nums[i][0];
                }
                res+=count+"\n";
                T--;
                continue;
            }
            PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>((a,b)->(nums[a][idx[a]]-nums[a][idx[a]-1])
                    -(nums[b][idx[b]]-nums[b][idx[b]-1]));
            StringBuilder sb=new StringBuilder(2*n-1);
            int count=0;
            for(int i=0;i<m;i++) {
                minHeap.offer(i);
                count+=nums[i][0];
            }
            sb.append(count+" ");
            for(int i=1;i<n;i++){
                int tempidx=minHeap.poll();
                count+=nums[tempidx][idx[tempidx]]-nums[tempidx][idx[tempidx]-1];
                sb.append(count+" ");
                if(idx[tempidx]<n-1){
                    idx[tempidx]++;
                    minHeap.offer(tempidx);
                }
            }
            res+=sb.toString()+"\n";
            T--;
        }
        System.out.println(res.substring(0,res.length()-1));

    }




}
