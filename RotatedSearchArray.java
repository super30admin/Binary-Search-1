// Time Complexity : O(logn) since one pass binary
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end){
            int middle = (start + end) / 2;
            if (nums[middle] == target){
                return middle;
            }
            
            else{ // 1. check pivot, 2. which half to perform binary search
                if (nums[middle] >= nums[start]){ // start to middle subarray is non-rotated, NOTE: equal sign since can only have 2 numbers in array for example and middle index pointing to same number as starting element
                    if (target < nums[middle] && target >= nums[start]){ // target is found in non-rotated subarray, proceed as normal, note again target can be start
                        end = middle - 1;
                    }
                    else{
                        start = middle + 1;
                        
                    }
                }
                else{ // middle to end subarray is non-rotated
                    if (target > nums[middle] && target <= nums[end]){ //target is found in non-rotated subarray, proceed as normal
                        start = middle + 1;
                    }
                    else{
                        end = middle - 1;
                    }
                }
            }
        }
        
        return -1;
    }
}