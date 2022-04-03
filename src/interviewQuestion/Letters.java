package interviewQuestion;

import java.util.Scanner;

public class Letters {
    static int R;
    static int S;
    static char[][] letters;
    static int res=0;
    static int[] dx={-1,1,0,0},dy={0,0,-1,1};
    static char[] alphabet=new char[26];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        S=sc.nextInt();
        letters=new char[R][S];
        for(int i=0;i<R;i++){
            letters[i]=sc.next().toCharArray();
        }
    DFS(0,0,0);
        System.out.println(res);
    }


    public static void DFS(int x,int y,int length){
        if(alphabet[letters[x][y]-'A']==0){
            length++;
        }
        alphabet[letters[x][y]-'A']+=1;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<R&&ny>=0&&ny<S){
                if(alphabet[letters[nx][ny]-'A']==0)
                DFS(nx,ny,length);
            }
        }
        res=Math.max(res,length);
        alphabet[letters[x][y]-'A']-=1;

    }

}
