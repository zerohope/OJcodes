package interviewQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sudoku {
    static int N=10;
    static char chess[][]=new char[N][N];
    static boolean[][] row=new boolean[N][N], col=new boolean[N][N];
    static boolean[][][] cell=new boolean[N][N][N];
    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        for(int i=0;i<9;i++) {
            char[] temp=reader.readLine().toCharArray();
            chess[i] =temp;
            for(int j=0;j<9;j++){
                if(temp[j]!='.'){
                    int val=temp[j]-'0';
                    row[i][val]=true;
                    col[j][val]=true;
                    cell[i/3][j/3][val]=true;
                }
            }
        }
       dfs(0,0);
    }
  public static boolean dfs(int x, int y){
        if(y==9)
          return dfs(x+1,0);
        if(x==9){
            for(int i=0;i<9;i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(chess[i][j]);
                }
                System.out.println();
            }
            return true;
        }
      if (chess[x][y] != '.') return dfs(x, y + 1);
       for(int i=1;i<=9;i++){
           if(!row[x][i]&&!col[y][i]&&!cell[x/3][y/3][i]){
               row[x][i]=col[y][i]=cell[x/3][y/3][i]=true;
               chess[x][y]= (char)(i+'0');
               if(dfs(x,y+1)) return true;
               row[x][i]=col[y][i]=cell[x/3][y/3][i]=false;
               chess[x][y]='.';
           }

       }
       return false;
  }



}
