// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, i dont have a premium. I'll buy it soon.
// Any problem you faced while coding this :
//Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

public class Q3BinarySearch {
    public int search(ArrayReader reader, int target){
        int low = 0, high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high *2;
        }
        while(low <= high){
            int mid = low +(high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
