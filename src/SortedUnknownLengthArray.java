// Time Complexity : O(log T) where T is the target value
// Space Complexity : O(1) - no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


/**
 * // This is ArrayReader's API interface..
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    /**
     * satrting from 0,1 index, increase the array till 2^k <= T <= 2^k+1 to find the target value and return the index of it
     * @param reader
     * @param target
     * @return index of the target value if found else -1
     */
    public int search(ArrayReader reader, int target) {
        int left=0,right=1,mid=0;
//        while(reader.get(right) != 2147483647){                             // until we get the subarray where the right end is out of bounds
//            if(reader.get(left) <= target && reader.get(right) >= target)   // if target is in between the subarray , left and right
//                return find(reader,target,left,right);                      // find the index of the target using normal binary search and return
//            else if(reader.get(right) < target)                             // if target is above right end, increase the subarray by movinf left to right and increasing right by 2
//            {
//                left = right;
//                right >>= 1;
//            }else{
//                return -1;
//            }
//        }
//        while(left <= right && reader.get(right) == 2147483647)           // after stmbling upon the last subarray and checking if the target lies here
//        {
//            mid = left + (right-left)/2;
//
//            if(reader.get(mid) == 2147483647)                             // if mid is out of bounds then move the right to mid-1
//                right = mid-1;
//            else if(reader.get(left) <= target && reader.get(mid) >= target)   // if target is in between the subarray , left and mid
//                return find(reader,target,left,mid);                           // find the index of the target using normal binary search and return
//            else if(target > reader.get(mid))                                  // if target is above mid end, increase the subarray by movinf left to mid
//                left = mid+1;
//            else
//                return -1;
//        }
        while(reader.get(right)<target)                        //Assuming the ArrayReader as the stream of integers and if the right element is less than target move it ahead by 2 else exit and do binary search on that subarray
        {
            left = right;
            right <<= 1;
        }
        return find(reader,target,left,right);
    }

    /**
     * Normal Binary Search, find mid of the array and if target is at the mid return it else chk if it lies in either half and repeat the procedure
     * @param reader
     * @param target
     * @param left
     * @param right
     * @return index of the target if found else return -1
     */
    public int find(ArrayReader reader, int target, int left, int right){
        int mid=0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(target >= reader.get(left) && target < reader.get(mid))
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }
}