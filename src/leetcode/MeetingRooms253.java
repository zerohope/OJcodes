import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms253 {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            List<List<int[]>> meetRooms=new ArrayList<>();
            int flag=0;
            List<int[]> meetRoom=new ArrayList<>();
            meetRoom.add(intervals[0]);
            meetRooms.add(meetRoom);
            for(int i=1;i<intervals.length;i++){
                flag=0;
                for(int j=0;j<meetRooms.size();j++){
                    meetRoom=meetRooms.get(j);
                    if(meetRoom.get(meetRoom.size()-1)[1]<=intervals[i][0]){
                        flag=1;
                        meetRoom.add(intervals[i]);
                        break;
                    }
                }
                if(flag==0){
                    meetRoom=new ArrayList<>();
                    meetRoom.add(intervals[i]);
                    meetRooms.add(meetRoom);
                }
            }
            return meetRooms.size();

    }
}
