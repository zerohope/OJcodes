package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CityGame {
    static long rs=0;
    public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] input=reader.readLine().split(" ");
        int n=Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
        int[][] high=new int[n][m+2];
        for(int i=0;i<n;i++){
            input=reader.readLine().split(" ");
            high[i][0]=-1;
            high[i][m+1]=-1;
            for(int j=1;j<=m;j++){
                if(i>0){
                    if(input[j-1].equals("F"))
                        high[i][j]=high[i-1][j]+1;
                }else{
                    if(input[j-1].equals("F")) {
                        high[i][j] = 1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
            findMax(high[i],m);
        System.out.println(rs*3);

    }

    public static void findMax(int[] h,int n) {
        Stack<Integer> s=new Stack<>();
        int[] l=new int[n+2];
        int[] r=new int[n+2];
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
           rs=Math.max(res,rs);
        }





}
