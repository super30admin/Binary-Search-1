// Time Complexity : O(logN) - N is size of array which is unknown
// Space Complexity : O(1) - No additional data structure is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//Used binary search to find the element
class Solution {
    public int search(ArrayReader reader, int target) {
      if(reader.get(0) == target) return 0;
        int left = 0,right = 1;
        while(reader.get(right) < target){
            left = right;
            right  = right * 2;;
        }
        int pivot,num;
        while(left <= right){
            pivot = left + ((right - left)/2);
            num = reader.get(pivot);
            if(target == num) return pivot;
            else if(target > num) left = pivot + 1;
            else{
                right = pivot - 1;
            }
        }
        return -1;
    }
}
// Your code here along with comments explaining your approach
