// Time Complexity : O(log n + log m), m being the numbers we iterate to pass the range and n being the time taken to search within the range
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Confusion related to low= mid+1 & high = mid


// Your code here along with comments explaining your approach

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // find the range in which target will lie
        //O(log m) time, m being the numbers we iterate to pass the range
        while(reader.get(high) < target){
            low = high;
            high = 2*high; // increase the range by two everytime
        }

        // apply binary search in the range to find the target
        //O(log n) TC
        while(low < high){
            int mid = low - ((low-high)/2);
            int val = reader.get(mid);
            //System.out.println(mid);

            if(val == target){
                return mid;
            }
            else if(target < val){ // target might lie in the left range
                high = mid;
            }
            else{ // right range
                low = mid+1;
            }
        }

        if(reader.get(low) == target){
            return low;
        }
        
        return -1;
    }
}