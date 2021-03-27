import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {
       public static void main(String[] args){

           System.out.println( checkInclusion("adc","dcda"));

       }



        public static boolean checkInclusion(String s1, String s2) {
            Map<Character,Integer> sst=new HashMap<>();
            for(int i=0;i<s1.length();i++){
                char rightChar=s1.charAt(i);
                sst.put(rightChar,sst.getOrDefault(rightChar, 0)+ 1);
            }
            for(int ep=0;ep<s2.length();ep++){
                if(sst.containsKey(s2.charAt(ep))){
                    Map<Character,Integer> mp=new HashMap<>();
                    mp.putAll(sst);
                    ep=nextep(s2,mp,ep);
                    if(ep==-1)
                        return true;
                }
            }

            return false;
        }
        public static int nextep(String s, Map<Character,Integer> map, int ep){
            for(int i=ep;i<s.length();i++){
                char rightChar=s.charAt(i);
                if(map.containsKey(rightChar)){
                    map.put(rightChar,map.get(rightChar)-1);
                    if(map.get(rightChar)==0)
                        map.remove(rightChar);
                    if(map.isEmpty())
                        return -1;
                }else{
                    return ep;
                }

            }
            return ep;
        }


    }


