package interviewQuestion;

public class ModeInArrays {

    public int moreThanHalfNum_Solution(int[] nums) {
        int val=0,count=0;
        for(int n:nums){
            if(count==0) {
                val = n;
                count=1;
            }else if(val==n)
                count++;
            else if(val!=n)
                count--;
        }
      return val;
    }


}
