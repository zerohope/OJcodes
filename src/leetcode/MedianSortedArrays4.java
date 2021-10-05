package leetcode;

public class MedianSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int left=(m+n+1)/2,right=(m+n+2)/2;
        return (findNums(nums1,0,m-1,nums2,0,n-1,left)+findNums(nums1,0,m-1,nums2,0,n-1,right))*0.5;
    }
    public double findNums(int[] nums1,int st1,int ed1,int[] nums2,int st2,int ed2,int k){
        int len1=ed1-st1+1,len2=ed2-st2+1;
        if(len1>len2) return findNums(nums2,st2,ed2,nums1,st1,ed1,k);
        if(len1==0) return nums2[st2+k-1];
        if(k==1) return Math.min(nums1[st1],nums2[st2]);
        int i=st1+Math.min(k/2,len1)-1,j=st2+Math.min(k/2,len2)-1;
        if(nums1[i]<nums2[j])
            return findNums(nums1,i+1,ed1,nums2,st2,ed2,k-(i-st1+1));
        else
            return findNums(nums1,st1,ed1,nums2,j+1,ed2,k-(j-st2+1));
        }
    }



