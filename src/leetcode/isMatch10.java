import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class isMatch10 {

    public static void main(String[] args){
        String s="ab";
        Map<Integer,String> rs=new HashMap<Integer, String>();
        List<String> sub=new ArrayList<String>();
        for(int i=0;i<s.length()-1;i++)
            for(int j=i+1;j<s.length();j++) {
                sub.add(s.substring(i, j+1));
            }
        int  temp=0;
        for(String t: sub){
            int flag=test(t);
            if(flag>0){
                if(flag>temp)
                    temp=flag;
                rs.put(flag,t);
            }
        }
        if(rs.get(temp)==null){
            if(s.equals("")){
                System.out.println("");
            }else{
                System.out.println(s.substring(0,1));
            }
        }
        System.out.println(rs.get(temp));


    }
    public static int test(String s){
        for(int i=0;i<s.length()/2;i++){

            if(s.charAt(i)==s.charAt(s.length()-i-1)){
                continue;
            }
            return 0;
        }
        return s.length();


    }
}



