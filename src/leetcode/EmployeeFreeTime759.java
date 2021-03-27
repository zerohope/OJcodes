import java.util.ArrayList;

public class EmployeeFreeTime759 {
  /*
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> merge=new ArrayList<>();
        List<Interval> res=new ArrayList<>();
        for(List<Interval> employee: schedule){
            if(merge.size()==0){
                merge=employee;
            }else{
                merge=employeeTime(merge,employee);
            }
        }
        for(int i=1;i<merge.size();i++){
            res.add(new Interval(merge.get(i-1).end,merge.get(i).start));
        }


        return res;
    }


    public List<Interval> employeeTime(List<Interval> em1, List<Interval> em2){
        List<Interval> merge=new ArrayList<>();
        int tail=-1;
        int i=0,j=0;
        Interval temp;
        while(i<em1.size()&&j<em2.size()){
            if(em1.get(i).start<em2.get(j).start){
                temp=em1.get(i++);
            }else{
                temp=em2.get(j++);
            }
            if(tail==-1||merge.get(tail).end<temp.start){
                merge.add(temp);
                tail++;
            }else{
                merge.get(tail).start=Math.min( merge.get(tail).start,temp.start);
                merge.get(tail).end=Math.max(merge.get(tail).end,temp.end);
            }
        }
        while(i<em1.size()){
            temp=em1.get(i++);
            if(merge.get(tail).end<temp.start){
                merge.add(temp);
                tail++;
            }else{
                merge.get(tail).start=Math.min( merge.get(tail).start,temp.start);
                merge.get(tail).end=Math.max(merge.get(tail).end,temp.end);
            }

        }
        while(j<em2.size()){
            temp=em2.get(j++);
            if(merge.get(tail).end<temp.start){
                merge.add(temp);
                tail++;
            }else{
                merge.get(tail).start=Math.min( merge.get(tail).start,temp.start);
                merge.get(tail).end=Math.max(merge.get(tail).end,temp.end);
            }

        }
        return merge;
    }

*/

}
