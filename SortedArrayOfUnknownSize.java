/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int result=0;
        int high = 1;
        while(reader.get(high)!=Integer.MAX_VALUE && reader.get(high)<=target){ //while high is less than target and not max value of integer
            high=high*2;                                                        // reverse approach to binary search by starting from a small space and doubling up
        }
        result = binarySearch(reader, target, 0, high);
        return result;
    }
    

    // binary search method to calculate the index at which target is found
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        
        while(low<=high){
            int mid = low + (high-low)/2; // calculating mid value for binary search algo
            
            if(reader.get(mid)==target){  // if value at mid is equal to target return mid
                return mid;
            }
            else if(reader.get(mid)>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}