package help;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;
//出栈需要元素位置的话，需将位置存在对象中
public class ImageIdentity {
    public static int[][] move=new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int tms=sc.nextInt();
		while(tms>0) {
		Point[][] ps=new Point[sc.nextInt()][sc.nextInt()];
		int dist=sc.nextInt();
			for(int i=0;i<ps.length;i++)
			  for(int j=0;j<ps[0].length;j++)
				  ps[i][j]=new Point(sc.nextInt(),i,j);
			      DFS(ps,dist);
			tms--;
		}
      sc.close();
	}
	
	public static void DFS(Point[][] ps,int dis) {
		//出栈需要元素位置的话，需将位置存在对象中
		//int[][] move=new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		int flag=0;
		Stack<Point> s=new Stack<Point>();
		for(int i=0;i<ps.length;i++)
		  for(int j=0;j<ps[0].length;j++)
		   if(ps[i][j].area==0&&s.isEmpty()) {
			   s.push(ps[i][j]);
			   while(!s.isEmpty()) {
				   Point p=s.pop();
				   p.area=1;
				   for(int k=0;k<8;k++) {
					   int ni=p.x+move[k][0];
					   int nj=p.y+move[k][1];
					if(ni>=0&&ni<ps.length&&nj>=0&&nj<ps[0].length) {
					if(ps[ni][nj].area==0&&Math.abs(ps[ni][nj].value-p.value)<=dis)
						    s.push(ps[ni][nj]);
					}
				   }
			   }
                 flag+=1;
		   }
               System.out.println(flag);
	}
}

class Point{
	int value;
	int area;
	int x,y;
	public Point(int value,int x,int y) {
		this.value=value;
		this.area=0;
		this.x=x;
		this.y=y;
	}
	
}