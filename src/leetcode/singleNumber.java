package leetcode;
import java.util.HashMap;
public class singleNumber {

    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> memory=new HashMap<>();
        for(int num:nums){
            System.out.println(memory.getOrDefault(memory.get(num),0)+"----"+memory.get(num));
            memory.put(num,memory.getOrDefault(memory.get(num),0)+1);
               if(memory.get(num)==3){
                memory.remove(num);
            }
        }
        return memory.entrySet().iterator().next().getKey();
    }
    
    public static void main(String[] args){
        singleNumber(new int[]{2,2,3,2});


    }
}
