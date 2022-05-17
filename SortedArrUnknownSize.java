// Time Complexity : O(logT) where T is index of target value
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        // initial check
        if (target == reader.get(0)) return 0;
        
        // search boundaries
        int left = 0;
        int right = 1;
        
        while (target > reader.get(right)){ // outside boundaries
            left = right + 1;
            right = right * 2;
        }
        
        // binary search within boundaries
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (reader.get(mid) == target){
                return mid;
            }
            else if (target < reader.get(mid)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return -1;
           
    }
}