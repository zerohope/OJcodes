package interviewQuestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FindRootAndChild {
    static int N=1001,M=N;
    static int m,n;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();n=sc.nextInt();
        boolean[] hasFather=new boolean[N];
        ArrayList<Integer>[] childs=new ArrayList[N];
        for(int i=0;i<n;i++){
            int father=sc.nextInt(),child=sc.nextInt();
            if(childs[father]==null) childs[father]=new ArrayList<>();
            hasFather[child]=true;
            childs[father].add(child);
        }
        for(int i=1;i<N;i++){
            if(childs[i]!=null||hasFather[i]==true){
                if(hasFather[i]==false){
                    System.out.println(i);
                }
            }
        }
        int max=-1;
        for(int i=1;i<N;i++){
            if(childs[i]!=null) {
                if(max==-1)
                    max=i;
                if (childs[i].size() > childs[max].size())
                    max = i;
            }
        }
        System.out.println(max);
        childs[max].sort(Comparator.comparingInt(a -> a));
        for(Integer i:childs[max])
            System.out.print(i+" ");
    }
}
