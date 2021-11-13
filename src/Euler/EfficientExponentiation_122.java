package Euler;

import java.util.*;


class TreeNode{
    List<TreeNode> children=new ArrayList<>();
    TreeNode parent;
    int value;
}

public class EfficientExponentiation_122 {

public static void main(String[] args){
    int total=199;
    int res=0;
    Map<Integer, List<Integer>> map=new HashMap<>();
    List<Integer> list=new ArrayList<>();
    list.add(1);
    map.put(0,list);
    int times=1;
    Set<Integer> memory=new HashSet<>();
    TreeNode root=new TreeNode();
    Queue<TreeNode> q=new LinkedList<>();
    root.value=1;
    memory.add(1);
    root.children=new ArrayList<>();
    q.offer(root);
    while(!q.isEmpty()){
        List<Integer> level=new ArrayList<>();
        int size=q.size();
        for(int i=0;i<size;i++){
            //当前节点
            TreeNode temp=q.poll();
            //父节点
            TreeNode parent=temp.parent;
            while(parent!=null){
                int val=temp.value+parent.value;
                if(!memory.contains(val)){
                    memory.add(val);
                    if(val<=200){
                        total--;
                        res+=times;
                    }
                    //子节点
                    TreeNode child=new TreeNode();
                    child.value=val;
                    child.parent=temp;
                    child.children=new ArrayList<>();
                    temp.children.add(child);
                    level.add(val);
                    q.offer(child);
                }
                parent=parent.parent;
            }
           int val=temp.value+temp.value;
            if(!memory.contains(val)){
                memory.add(val);
                //子节点
                if(val<=200){
                    total--;
                    res+=times;
                }
                TreeNode child=new TreeNode();
                child.value=val;
                child.parent=temp;
                child.children=new ArrayList<>();
                temp.children.add(child);
                level.add(val);
                q.offer(child);
            }


        }
        map.put(times++,level);
        if(times==15){
            break;
        }

    }

    System.out.println("---");
}













    //没有发现是树形结构
    /*public static void main(String[] args){
        List<Integer> s=new ArrayList<>();
        s.add(1);
        Map<Integer, List<Integer>> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        map.put(0,list);
        int ed=-1;
        for(int i=1;i<=5;i++){
            int st=ed+1;
            ed=s.size()-1;
            List<Integer> t=new ArrayList<>();
            for(int j=st;j<=ed;j++){
                int cur=s.get(j);
                for(int z=0;z<=st-1;z++){
                    int temp=s.get(z);
                    if(!s.contains(cur+temp)){
                        s.add(cur+temp);
                        t.add(cur+temp);
                    }
                }
                if(!s.contains(cur+cur)){
                    s.add(cur+cur);
                    t.add(cur+cur);
                }
            }
            map.put(i,t);
        }

        System.out.println("---");


    }*/




    //失败的动态规划
  /*  public static void main(String[] args) {
        int[][] dp = new int[201][201];
        int[] times=new int[201];
        times[1]=0;times[2]=1;
        for (int i = 1; i <=200; i++) {
            dp[1][i] = i-1;
        }
        for (int i = 1; i <=200; i++) {
            dp[i][1] = 0;
        }
        for (int i = 2; i <=200; i++) {
            times[i]=findTimes(dp,i,times);
            for (int j = 2; j <=200; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - i >= 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - i] + times[i]);
                }
            }
        }
        System.out.println(dp[1][1]);

    }
    public static int findTimes(int[][] dp,int n,int[] times){
        int[] count=new int[201];
        int res=0;
        int flag=n;
        int i;
        for( i=n-1;i>=1; ){
            if(dp[i][flag]==dp[i-1][flag]){
                i--;
                continue;
            }else{
                break;
            }
        }
        res=dp[i][flag];
        return res;
    }*/

}