// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No - premium question
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1: We set a fixed range to search within and then use ArrayReader to double the range in which we're searching
// 2: We use the ArrayReader to get the mid element
// 3: And use Binary Search as normal to find the target element
class Solution{
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        };

        while(low <= high){
            int mid = low + (high-low)/2;

            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}