import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses22 {

    public static void main(String[] args){
        generateParenthesis(3);
    }

    public static  List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        Queue<parenthesisString> q=new LinkedList<>();
        q.offer(new parenthesisString("",0,0));
        while(!q.isEmpty()){
            parenthesisString p=q.poll();
            if(p.left==n&&p.right==n){
                res.add(p.s);
            }
            if(p.left<n){
                q.offer(new parenthesisString(p.s+"(",p.left+1,p.right));
            }
            if(p.right<n){
                q.offer(new parenthesisString(p.s+")",p.left,p.right+1));
            }

        }
        return res;
    }

}


class parenthesisString{
    String s;
    int left;
    int right;

    parenthesisString(String s, int l, int r){
        this.s=s;
        this.left=left;
        this.right=right;
    }
}