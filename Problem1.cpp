//LeetCode #33. Search in Rotated Sorted Array
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:
/* 
   When we divide the vector(or portion of vector) at 'mid' value, it is
   sure that either the elements from left to mid or mid+1 to right are sorted.
   Then basing on the fact that if target lies in the sorted part 
   of the vector or not, we move the left and right pointers.
   This is continued until we find the target or left <= right.
   If the element is not present in the vector, we return -1.
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size()-1;
        
        while(left <= right){
            //making sure integer overflow is not happening
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            // checking if elements starting from left index to mid index are sorted
            else if(nums[left] <= nums[mid]){ 
                // checking if target is in the sorted part
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                } 
                else{
                    left = mid + 1;
                }
            }
            // elements starting from mid index to right index are sorted
            else{
                // checking if target is in the sorted part
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
};