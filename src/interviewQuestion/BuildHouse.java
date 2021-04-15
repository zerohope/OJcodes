package interviewQuestion;

public class BuildHouse {
    public static void buildHouse(int n,int flag){
        if(n==0){
            if(flag==0)
                System.out.print("G");
            else
                System.out.print("R");
            return ;
        }
        buildHouse(n-1,0);
        if(flag==0)
            System.out.print("G");
        else
            System.out.print("R");
        buildHouse(n-1,1);
    }
    public static void main(String[] args){
        buildHouse(4,1);
    }

}
