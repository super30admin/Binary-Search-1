//TC: O(log T) where T is index value
//SC: O(1)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //find the range first: low and high
        int low=0;
        int high=1;
        while(reader.get(high) < target){
            
                low = high;
                high=2*high;
            
        }
	//Implement Binary Search
        while(low<=high){
            int mid = low + (high - low)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid) > target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

