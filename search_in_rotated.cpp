/*Time Complexity :O(log(n))
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
1) we find the middle element using binary search. Then determine if left half of right half is sorted.
2)If left half is sorted then check if the target lies within the left half range. If the target lies then high = mid-1
else low = mid +1
3) Do the same thing if the right half is sorted.
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == nums[mid])return mid;
            else if(nums[mid]>=nums[low])//left half is sorted
            {
                if(target < nums[mid] && target >=nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid +1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;

        
    }
};