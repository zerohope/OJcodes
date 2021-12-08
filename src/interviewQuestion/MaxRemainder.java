package interviewQuestion;

import java.util.*;

public class MaxRemainder {
    static int[] arr=new int[34];
    static int n;static int m;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        List<Integer> nums1=new ArrayList<>(),nums2=new ArrayList<>();
        dfs(nums1,0,n/2,0);
        dfs(nums2,n/2+1,n-1,0);
        Collections.sort(nums1);
        Collections.sort(nums2);
        int max=nums1.get(nums1.size()-1)+nums2.get(nums2.size()-1)-m;
        for(int i=0,j=nums2.size()-1;i<nums1.size();i++){
            while(nums1.get(i)+nums2.get(j)>=m) j--;
            if(j>=0)
                max=Math.max(max,nums1.get(i)+nums2.get(j));
        }
        System.out.println(max);
    }
    static void dfs(List<Integer> list,int st,int ed,int num){
        if(st>ed) {
            list.add(num % m);
            return;
        }
        else{
            dfs(list,st+1,ed,num+arr[st]);
            dfs(list,st+1,ed,num);
        }
    }

}
