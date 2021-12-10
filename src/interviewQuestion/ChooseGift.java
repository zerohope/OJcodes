package interviewQuestion;

import java.util.*;

public class ChooseGift {
    static int[] weights=new int[46];
    static int W;
    static int N;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        W=sc.nextInt();N=sc.nextInt();
        for(int i=0;i<N;i++){
            weights[i]=sc.nextInt();
        }
        Set<Long> table=new HashSet<>();
        dfs(table,0,N/2,0);
        List<Long> w1=new ArrayList<>(table);
        table.clear();
        dfs(table,N/2+1,N-1,0);
        List<Long> w2=new ArrayList<>(table);
        Collections.sort(w1);Collections.sort(w2);
        long res=0;
        for(int i=0,j=w2.size()-1;i<w1.size()&&j>-1;i++){
            while(w1.get(i)+w2.get(j)>W) j--;
            res=Math.max(res,w1.get(i)+w2.get(j));
        }
        System.out.println(res);
    }
 public static void dfs(Set<Long> list,int st,int ep,long w){
        if(w>W)
            return;
        if(st>ep)
          list.add(w);
        else{
            dfs(list,st+1,ep,w+weights[st]);
            dfs(list,st+1,ep,w);
        }

 }


}
