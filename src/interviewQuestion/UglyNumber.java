package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
    public int getUglyNumber(int n) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        int i=0,j=0,k=0;
        while(list.size()<=n){
            int t=Math.min(list.get(i)*2,Math.min(list.get(j)*3,list.get(k)*5));
            list.add(t);
            if(list.get(i)*2==t) i++;
            if(list.get(j)*3==t) j++;
            if(list.get(k)*5==t) k++;
        }
        return list.get(list.size());
    }

}
