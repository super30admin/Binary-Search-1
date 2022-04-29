// Time Complexity : O(logN) or O(T) as the boundary is not definite and depends on boundary - unsure
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes 
//          -I needed help understanding the setting of boundaries for the unknown array size


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
        //Iniitalise to the first two values
        int left = 0;
        int right = 1;
        int multiplication_factor = 2;//is used to move the right pointer
        while(reader.get(right)<target){
            left = right;
            right *= multiplication_factor;
        }
        
        while(left<=right){//normal binary search implementation
            int mid = left+((right-left)/2);
            int num = reader.get(mid);
            if(num==target){
                return mid;
            }
            if(num>target){
                right = mid-1;
            }else{
                left = mid+1;
            }   
        }
        return -1;
    }
}