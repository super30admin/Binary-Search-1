// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size

// Time Complexity : o(log n)
// Space Complexity :o (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class SearchInRotatedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0; 
        int high = 1; 

        // increasing the search space
        while(reader.get(high) < target) {
            low = high/2;
            high = high * 2;
        }

        while(low <= high) {
            int mid = low + (high-low) /2;
            if(reader.get(mid) == target) return mid;

            if(reader.get(mid) > target) {
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
