import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords30 {

    public static void main(String[] args){
       // System.out.println(findSubstring("s",));
    }



    public List<Integer> findSubstring(String s, String[] words) {
        int sp=0,matches=0;
        List<Integer> rs=new ArrayList<>();
        Map<String, Integer> cfreq=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String rightString=words[i];
            cfreq.put(rightString,cfreq.getOrDefault(rightString,0)+1);
        }
        int step=words[0].length();
        for(int ep=step;ep<s.length();ep=ep+step){
            String rightString=s.substring(ep-step,ep+1);
            if(cfreq.containsKey(rightString)){
                cfreq.put(rightString,cfreq.get(rightString)-1);
                if(cfreq.get(rightString)==0)
                    matches++;
                if(matches==cfreq.size()){
                    rs.add(sp);
                    String leftString=s.substring(sp,sp+step+1);
                    cfreq.put(leftString,cfreq.get(leftString)+1);
                    matches--;
                    sp+=step;
                }
            }
            if(ep-sp+1>=step*words.length){
                String leftString=s.substring(sp,sp+step+1);
                if(cfreq.containsKey(leftString)){
                    cfreq.put(leftString,cfreq.get(leftString)+1);
                    if(cfreq.get(leftString)==1)
                        matches--;
                }
                sp+=step;
            }
        }
        return rs;
    }
}
