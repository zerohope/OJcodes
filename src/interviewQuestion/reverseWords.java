package interviewQuestion;

import java.util.Scanner;
import java.util.Stack;

public class reverseWords {
    public String reverseWords(String s) {
        if (s.length() <= 1) return s;
        char[] words=s.toCharArray();
        swap(words,0,words.length-1);
        for(int i=0;i<words.length;i++){
            int j=i;
            while(j<words.length&&words[j]!=' ')j++;
            swap(words,i,j-1);
            i=j;
        }
        return new String(words);
    }
    public void swap(char[] arr,int i, int j){
        while(i<j){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }





    public static void stackSolver(String[] args){
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        word=word.substring(1,word.length()-1);
        String[] words=word.split(" ");
        Stack<String> s=new Stack<>();
        for(String w:words){
            s.push(w);
        }
        String res="";
        while(!s.isEmpty())
            res+=s.pop()+" ";
        res=res.substring(0,res.length()-1);
        System.out.println("\""+res+"\"");
    }



}
