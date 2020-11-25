/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class UnknownSize {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high =1;
        while(target > reader.get(high)){
            low = high;
            high = 2*high;
        }
        return binarySearch(reader,low,high,target);
    }
    
    public int binarySearch(ArrayReader reader, int low, int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            int element = reader.get(mid);
            if(element==target){
                return mid;
            }else if(element>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}