/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //define pointers low and high
        int low = 0;
        int high = 1;
        //to minimise the search space we can compare with target
    while(reader.get(high) < target){
            low = high ;
        high = high * 2;
    }
    
        //The moment we find a place where we get infinity, we can call binary search
    return helperForBinarySearch(reader, target, low, high) ;  
            
        }
    
    
    

private int helperForBinarySearch(ArrayReader reader, int target, int low, int high)    {
    while(low <= high){
        int mid = low + (high -low)/2 ;
        if(reader.get(mid) == target) return mid;
        else if(reader.get(mid) > target) high = mid - 1;
        else low = mid + 1;
    }
    return -1;
}

}
