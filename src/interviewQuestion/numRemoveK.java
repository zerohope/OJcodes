package interviewQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class numRemoveK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int k=Integer.parseInt(br.readLine());
        int l=str.length();
        if(l<=k) {
            System.out.println(0);
        }else {
            for(int i=1;i<str.length()&&k>0;){
                if(str.charAt(i)<str.charAt(i-1)){
                    str=str.substring(0,i-1)+str.substring(i);
                    k--;
                    i--;
                }else{
                    i++;
                }
            }
            if(k>0){
                str=str.substring(0,str.length()-k);
            }
            while(str.charAt(0)=='0'){
                str=str.substring(1);
            }
            System.out.println(str);
        }

    }
}
