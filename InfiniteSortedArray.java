// Time Complexity : O(log(n))
// Space Complexity : 0
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : how to set the high pointer

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;
        
        // Get index for high pointer by doubling it until it's greater than the target
        while(reader.get(high) <= target) {
            high = high*2;
        }
        while (low <= high) {
            
            int mid = (low+high) / 2;
            
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}