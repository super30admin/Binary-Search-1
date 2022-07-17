// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class SearchSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        //if the target is greater than the high element, double the size and search within the next range
        while(target > reader.get(high)){
            low = high;
            high = high * 2;
        }

        //binary search of the target element
        while(low <= high){
            int mid = low+(high-low)/2;

            if(reader.get(mid) == target) {
                return mid;
            } else if(target > reader.get(mid)) {
                low = mid+1;
            } else if(target < reader.get(mid)) {
                high = mid-1;
            }
        }
        return -1;
    }
}