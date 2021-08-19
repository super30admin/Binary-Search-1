//Search in a Sorted Array of Unknown Size


// Search in 2D matrix.

// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : bit difficult to understand the binary search concepts using recurrsion.


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {

        //In order to solve this problem there are two  steps to follow.

        // 1.) Define boundaries.
        //2.) Perform binary search.

        int left=0;
        int right=1;

        while(reader.get(right) < target){
            left=right;
            right=right*2;
        }

        while(left<=right){

            int index = (left+(right-left)/2);

            int num = reader.get(index);

            if(num == target){
                return index;
            }

            if(num <target){
                left = index+1;
            }else{
                right = index-1;
            }
        }
        return -1;

    }
}