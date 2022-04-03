/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : O(log(N))
// Space Complexity : O(1), No extra data structure used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
    /*
    1. first fix the search space. set high and low then regular binary search.
     */
class SortedArrayUnkownSize {
    public int search(ArrayReader reader, int target) {
        int low=0,high=1;
        while(reader.get(high)<target){
            low=high;
            high=high*2;
        }

        return binarySearch(reader,target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            int value=reader.get(mid);
            if(value==target){
                return mid;
            }else if(value<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }
}