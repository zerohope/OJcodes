package interviewQuestion;



import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class IdxNode{
    int idx;
    TreeNode node;
    public IdxNode(int idx,TreeNode val){
        this.idx=idx;
        this.node=val;
    }
    public String toString(){
        int idx=this.idx;
        int val=this.node.val;
        return "["+idx+";"+val+"]";
    }
}

public class SerializeBinaryTree {
    public static void main(String[] args){
      TreeNode root=new TreeNode(8);
      root.right=new TreeNode(1);
      root.right.right=new TreeNode(4);
      System.out.println(serialize(root));
      System.out.println(serialize(deserialize(serialize(root))));

    }
   static   String serialize(TreeNode root) {
        if(root==null)
            return "null";
       Queue<IdxNode> q=new LinkedList<>();
       q.offer(new IdxNode(1,root));
       String res="";
       List<IdxNode> lists=new ArrayList<>();
       while (!q.isEmpty()){
            int length=q.size();
            for(int i=0;i<length;i++){
                IdxNode temp=q.poll();
                int idx=temp.idx;
                lists.add(temp);
                if(temp.node.left!=null) {
                    q.offer(new IdxNode(2*idx,temp.node.left));
                }
                if(temp.node.right!=null) {
                    q.offer(new IdxNode(2*idx+1,temp.node.right));
                }
            }
        }
       for(IdxNode s:lists){
           res+=s.toString()+",";
       }
        return res;
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
        if(data.equals("null"))
            return null;
        String[] nodes=data.split(",");
        Map<Integer,Integer> map=createMap(nodes);
        TreeNode root=new TreeNode(map.get(1));
        Queue<IdxNode> q=new LinkedList<>();
        q.offer(new IdxNode(1,root));
        while(!q.isEmpty()){
            int length=q.size();
            for(int i=0;i<length;i++){
                IdxNode temp=q.poll();
                int idx=temp.idx;
                if(map.containsKey(2*idx)){
                    temp.node.left=new TreeNode(map.get(2*idx));
                    q.offer(new IdxNode(2*idx,temp.node.left));
                }
                if(map.containsKey(2*idx+1)){
                    temp.node.right=new TreeNode(map.get(2*idx+1));
                    q.offer(new IdxNode(2*idx+1,temp.node.right));
                }

            }


        }



        return root;
    }
  static Map<Integer,Integer> createMap(String[] value){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<value.length;i++){
           String temp=value[i].substring(1,value[i].length()-1);
           String[] kv=temp.split(";");
           map.put(Integer.parseInt(kv[0]),Integer.parseInt(kv[1]));
        }
        return map;
  }

}
