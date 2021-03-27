import java.util.Scanner;

public class Numberconversion {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
        String cl=sc.nextLine();
        String nb=cl.substring(4,cl.length()-1);
            System.out.println(nb);
        String[] nbs=nb.split(",");
        String rs="";
        for(int i=nbs.length-1;i>-1;i--){
            System.out.println(nbs[i]);
            String temp=Integer.toBinaryString(Integer.parseInt(nbs[i]));
            while (temp.length()<8)
                temp='0'+temp;
            rs=temp+rs;
        }
            System.out.println(Integer.parseInt(rs,2));
        }

    }



}
