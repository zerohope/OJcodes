package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumericalCode {

    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String[] s = reader.readLine().split(" ");
        String start="",end="12345678x";

        for(String st:s)
            start+=st;
        System.out.println(playChess(start,end));
    }
    public static int playChess(String start,String end){
        if(start.equals(end))
            return 0;
        Map<String,Integer> state=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        q.offer(start);
        state.put(start,0);
        int[] dx=new int[]{0,0,-1,1},dy=new int[]{1,-1,0,0};
        while(!q.isEmpty()){
           String temp=q.poll();
           int x,y;

           if(temp.equals(end))
               return state.get(end);
           int idx=temp.indexOf('x');
                    x = idx / 3;
                    y = idx % 3;

            for(int i=0;i<4;i++){
                int nx=x+dx[i],ny=y+dy[i];
                if(nx<0||nx>2||ny<0||ny>2)continue;
                char[] arr=temp.toCharArray();
                changeChar(arr,idx,nx*3+ny);
                String str=new String(arr);
                if(state.get(str)==null){
                    state.put(str,state.get(temp)+1);
                    q.offer(str);
                }
            }

        }
        return -1;
    }
        public static void changeChar(char[] arr,int x,int y){
            char org=arr[x];
            arr[x]=arr[y];
            arr[y]=org;
    }

}
