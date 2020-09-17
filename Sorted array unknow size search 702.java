/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {// O(log n)
    public int search(ArrayReader reader, int target) {
        int left = 0 ;
        int right = 1 ; 
        // int mid ;
        
        while (reader.get(right) <= target){
            left = right;
            right = right * 2 ;
        }
        return binarySearch(reader, target , left , right);
    }
    public int binarySearch (ArrayReader reader, int target , int left , int right){
        if (left > right) return -1 ;
        int mid = left + (right-left)/2;
        if(reader.get(mid)== target){
            return mid;
        }
        if(target >= reader.get(mid)){
            //searching right side of mid
            return binarySearch(reader, target , mid+1 , right);
        }else{
            // search in left part of mid
            return binarySearch(reader, target , left , mid-1);
        }
    }
}