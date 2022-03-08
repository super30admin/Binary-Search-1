// Time Complexity : All the operations are done in O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Couldn't try, do not have premium subscription.
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Binary search with conditions such that:
1. if mid value is less than mid+1 value, increase high by high*2 and low - old high.
2. once mid is equal to value, return it.
*/
public class SearchSortUnknown {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high*2;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            } else if(reader.get(mid) > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
