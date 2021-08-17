702. Search in a Sorted Array of Unknown Size
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
Running Time complexity: O(logn)
Space Complexity: Constant
Sucessfully Run and Compiled on leetcode
*/
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; int high = 1;
        while(reader.get(high)<Integer.MAX_VALUE && target > reader.get(high)){
            low = high;
            high = high * 2;
        }
        return binarySearch(reader,high,low,target);
        
    }
    private int binarySearch(ArrayReader reader,int high, int low, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target) return mid;
            else if (reader.get(mid)>target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }
}