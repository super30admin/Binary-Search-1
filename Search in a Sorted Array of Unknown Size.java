/*
Time Complexity : The numbers of elements on which binary search will be is performes is (total = high-low+1) i.e total would be the index of the 
target value in the worst case. Hence to determine range, the time complexity is O(log(total)) and the binary search is performed once which would
 take O(log(total)) time. Hence the total is O(log(total)).
Space complexity : O(1).
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes on how to go about it
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
        int low = 0, high = 1;
        
        // determine the range to perform the binary search
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
            // high is multiplied by 2 as it gives the least range when compared to multiplying with graeter values and this is seen to benifit w.r.t log time
        }
        return binarySearch(reader,target,low,high);
    }
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low +(high-low) / 2;
            if(reader.get(mid) == target){
                return mid;
            }
            if(target < reader.get(mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}