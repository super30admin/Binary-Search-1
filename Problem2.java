// Time Complexity : O(log(n) + log(m)) --> where n is the size of the input array and m is the size of the subarray (of the array with size n ),  where the target lies
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
        
        //start the iteration from first and the second index
        int left = 0;
        int right = 1;
        
        //find the window where the target lies
        while(reader.get(right) < target){
            left = right;
            right = right*2;
        }
        
        //perform binary search in that window, to find the target
         return binarySearch(reader, target, left, right);
    }
    
    public int binarySearch(ArrayReader reader, int target, int left, int right){
        //continue searching till left index is less than right index
        while(left <= right){
            //calculate mid index
            int mid = left + (right - left);
            //if mid== target, you got the index where target is
            if(reader.get(mid) == target){
                return mid;
            }
            //if mid index value is smaller than target, then move to the right
            else if(reader.get(mid) < target){
                left = mid+1;
            }
            //if mid index value is greater than target, then move to the left
            else{
                right = mid-1;
            }
        }
        //return -1 if target not found
        return -1;
    }
}