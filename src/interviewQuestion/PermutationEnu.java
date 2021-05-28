package interviewQuestion;

import java.util.*;

public class PermutationEnu {
    static int N=10;
    static int[] res=new int[N];
    static boolean[] visit=new boolean[N];


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();

        dfs(0);
    }

    public static void dfs(int idx){

            for(int i=1;i<=N;i++){
                if(!visit[i]){
                    visit[i]=true;
                    res[idx]=i;
                    dfs(idx+1);
                    visit[i]=false;
                }
            }
        if(idx==N){
            for(int i=0;i<N;i++)
                System.out.print(res[i]+" ");
            System.out.println("");
        }

    }







    //没有办法字典序
    public static void test(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1||n==0)
            System.out.println(n);;
        Queue<List<Integer>> q=new LinkedList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        q.offer(temp);
        permutate(q,2,n);
        StringBuilder res=new StringBuilder();
        while(!q.isEmpty()){
            List<Integer> t=q.poll();
            for(int i=0;i<t.size();i++)
                res.append(t.get(i)+" ");
            res.append("\n");
        }
        System.out.println(res.toString().substring(0,res.length()-1));
    }
    public static void permutate(Queue<List<Integer>> q,int idx,int n){
        if(idx>n)
            return ;
        int size=q.size();
        for(int i=0;i<size;i++){
            List<Integer> temp=q.poll();
            for(int j=temp.size();j>-1;j--){
                List<Integer> next=new ArrayList<>(temp);
                next.add(j,idx);
                q.offer(next);
            }

        }
        permutate(q,idx+1,n);
    }




}
