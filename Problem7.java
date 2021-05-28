// Time Complexity : O(logi), where i is index of the target element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int search(ArrayReader reader, int target) {
        //1.find search space
        int right = 1;
        while(reader.get(right) < target){
            right = right << 1;
        }
        int left = right >> 1;

        // now we constrain the search space in [left,right]
        //2.do binary search in search space
        while(left <= right){
            int mid = (left + right) / 2;
            int mid_val = reader.get(mid);
            if(mid_val == target){
                return mid;
            }
            if(mid_val > target){
                right = mid - 1;
            }
            if(mid_val < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}