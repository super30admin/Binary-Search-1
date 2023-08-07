// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// low = 0; high =1; until we find the index of the element which is less than raget we will shift our low to high and high to hight*2
// this way we will get the side the target is present in, from there we need to do another BS to find the ele
// also when we are doing high = high*2 in step-1, it is okay if it exceeds the array size, because it is gonna return Integer.MAX_VALUE

class UnsortedSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target) {
            low = high;
            high = high*2;
        }
        while(low <= high){
           int mid = low + ((high - low)/2);
           if(reader.get(mid) == target) return mid;
           else if(reader.get(mid) > target) high = mid-1;
           else low = mid + 1;
        }
        return -1;
    }
}
