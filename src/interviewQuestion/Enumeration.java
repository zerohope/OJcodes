package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enumeration {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        List<List<Integer>> emu=new ArrayList<>();
        emu.add(new ArrayList<>());
        addNum(emu,1,num);
        StringBuilder res=new StringBuilder();
        for(List<Integer> temp:emu){
            for(int i=0;i<temp.size();i++)
                res.append(temp.get(i)+" ");
            res.append("\n");
        }
        System.out.println(res.toString().substring(0,res.length()-1));
    }

    public static void addNum(List<List<Integer>> emu,int idx, int num){
        if(idx>num)
            return ;
        int length=emu.size();
        for(int i=0;i<length;i++){
            List<Integer> temp=new ArrayList<>(emu.get(i));
            temp.add(idx);
            emu.add(temp);
        }
        addNum(emu,idx+1,num);
    }








}
