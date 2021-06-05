package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxRectangleInHistogram {
    static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    static int[] h=new int[100002];
    static int[] l=new int[100002];
    static int[] r=new int[100002];
    public static  void main(String[] args) throws Exception{
        Stack<Integer> s=new Stack<>();
        String[] nums=input.readLine().split(" ");
        h[0]=-1;
        while(Integer.parseInt(nums[0]) != 0){
          int n=Integer.parseInt(nums[0]);
          h[n+1]=-1;
          for(int i=1;i<=n;i++)
            h[i]=Integer.parseInt(nums[i]);
          s.push(0);
          for(int i=1;i<=n;i++){
              while(h[s.peek()]>=h[i])
                  s.pop();
              l[i]=s.peek();
              s.push(i);
          }
          s.clear();
          s.push(n+1);
          for(int i=n;i>=1;i--){
              while(h[s.peek()]>=h[i])
                 s.pop();
              r[i]=s.peek();
              s.push(i);
          }
            long res=0;
            for(int i=1;i<=n;i++){
                res=Math.max(res,(long)h[i]*(r[i]-l[i]-1));
            }
            System.out.println(res);
            nums=input.readLine().split(" ");
        }

    }
}
