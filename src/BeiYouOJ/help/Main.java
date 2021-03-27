package help;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
     Scanner sc=new Scanner(new BufferedInputStream(System.in));		
     
     int tms = sc.nextInt();
      String[] ends=new String[tms];
     for(int i = 0; i < tms; ++i)
     {
        int flag = 0;
        int size = sc.nextInt();
        int[] nodes = new int[size + 1];
        nodes[0] = -1;
        for (int j = 1; j <= size; ++j)
            nodes[j] = sc.nextInt();
        while(size > 1)
        {
            if (nodes[sc.nextInt()] > nodes[sc.nextInt()])
            {
                flag = 1;
                break;
            }
            size--;
        }
        if (flag == 1)
           ends[i]="NO";
        else
            System.out.println("YES");
     }
     sc.close();
	}
}
