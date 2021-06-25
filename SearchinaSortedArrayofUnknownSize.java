// Time Complexity : o(logn)
// Space Complexity : constant
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

        int left = 0;
        int right = 1;
        int mid;

        while(target> reader.get(right)) right = right * 2;

        while(left<=right){

            mid = (left+right)/2;

            if(reader.get(mid) == target) return mid;

            else if(reader.get(mid) > target){

                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;

    }
}
