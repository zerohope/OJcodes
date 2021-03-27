public class SearchinaSortedArrayofUnknownSize702 {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     *     public int get(int index) {}
     * }
     */

/*        public int search(ArrayReader reader, int target) {
            int left=0,right=Integer.MAX_VALUE,mid=0;
            while(left<=right){
                mid=(left+right)/2;
                if(reader.get(mid)==Integer.MAX_VALUE)
                    right=mid-1;
                else
                    left=mid+1;
            }
            right=left-1;
            left=0;
            while(left<=right){
                mid=(left+right)/2;
                if(reader.get(mid)==target)
                    return mid;
                else if(reader.get(mid)<target)
                    left=mid+1;
                else
                    right=mid-1;
            }
            return -1;
        }
    }*/
}
