import java.util.ArrayList;
import java.util.List;

public class StringPermutationsbychangingcasemedium {

    public static  void main(String[] args){

        System.out.println(findLetterCasesStringPermutation("ab52"));

    }


    public static List<String> findLetterCasesStringPermutation(String str){
        List<String> res=new ArrayList<>();
        res.add(str);
        for(int i=0;i<str.length();i++)
            if(Character.isLetter(str.charAt(i))) {
                int n = res.size();
                for(int j=0;j<n;j++){
                    char[] chs=res.get(j).toCharArray();
                    if(Character.isUpperCase(chs[i]))
                        chs[i]=Character.toLowerCase(chs[i]);
                    else
                        chs[i]=Character.toUpperCase(chs[i]);
                    res.add(String.valueOf(chs));

                }
            }
        return  res;


    }

}
