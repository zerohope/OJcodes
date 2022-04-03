package interviewQuestion;

import java.util.Scanner;

public class ChessboardQuestion {
    static char[][] chessboard;
    static boolean[] check;
    static int n;
    static int k;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            n=sc.nextInt();
            k=sc.nextInt();
            if(n==-1&&k==-1)
                break;
            chessboard=new char[n][n];
            check=new boolean[n];

            for (int i=0;i<n;i++)
                chessboard[i]=sc.next().toCharArray();

            System.out.println(dfs(0,0));
        }

    }

public static int dfs(int r,int s){
        if(s==k)
            return 1;
        if(r==n)
            return 0;
        int res=dfs(r+1,s);
        for(int i=0;i<n;i++){
            if(!check[i]&&chessboard[r][i]=='#'){
                check[i]=true;
                res+=dfs(r+1,s+1);
                check[i]=false;
            }

        }
        return res;
}

}
