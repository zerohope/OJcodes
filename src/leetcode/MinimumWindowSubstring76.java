import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static void main (String[] args){

        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));

    }
    public static String minWindow(String s, String t) {
        int sp=0,matches=0;
        String minS="";
        Map<Character, Integer> cfreq=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char rightChar=t.charAt(i);
            cfreq.put(rightChar,cfreq.getOrDefault(rightChar,0)+1);
        }
        for(int ep=0;ep<s.length();ep++){
            char rightChar=s.charAt(ep);
            if(cfreq.containsKey(rightChar)){
                cfreq.put(rightChar,cfreq.get(rightChar)-1);
                if(cfreq.get(rightChar)==0)
                    matches++;
                while(matches==cfreq.size()){
                    if((s.substring(sp,ep+1)).length()<minS.length()) {
                        minS = s.substring(sp, ep + 1);
                    }
                    char leftChar=s.charAt(sp);
                    if(cfreq.containsKey(leftChar)){
                        cfreq.put(leftChar,cfreq.get(leftChar)+1);
                        if(cfreq.get(leftChar)>0)
                            matches--;
                    }
                    sp++;
                }
            }
        }
        return minS;
    }


}
