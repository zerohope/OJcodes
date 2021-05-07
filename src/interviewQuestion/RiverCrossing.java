package interviewQuestion;

import java.io.*;
import java.util.*;

public class RiverCrossing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = reader.readLine().split(" ");
        int m = Integer.parseInt(temp[0]);

        while(m-- > 0){
            int n = Integer.parseInt(reader.readLine().trim());
            long[] f = new long[n+10];
            int[] a = new int[n+1];
            a[0] = Integer.MIN_VALUE;
            temp = reader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(temp[i-1]);
            }
            Arrays.sort(a);
            if (n <= 2){
                System.out.println(a[2]);
                continue;
            }else{
                for (int i = n; i >= 4; i--) {
                    f[i] = a[i]+a[2]+f[i+1];
                    if (i+1 <= n) f[i] = Math.min(f[i], a[3]+a[3]+a[2]+a[i+1]+f[i+2]);
                    if (i+2 <= n) f[i] = Math.min(f[i], a[2]+a[2]+a[3]+a[4]+a[4]+a[i+2]+f[i+3]);
                }
            }
            System.out.println(a[3]+f[4]);
        }
    }
}

