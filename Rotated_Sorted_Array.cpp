// Time complexity : O(log(n))
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    int search(vector<int>& nums, int target) {

        if(nums.size()==0){
            return -1;
        }        
        int low = 0;
        int high = nums.size()-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(target == nums[mid]){
                return mid;
            }
            
            else if(nums[low] <= nums[mid]){  //If left array is sorted
                if(target >= nums[low] && target < nums[mid]){ //if num is lying on left side
                    high =mid-1;  //adjust the high
                }else{
                    low=mid+1;    //adjust the low
                }
            } 
            else{  //If right array is sorted
                if(target > nums[mid] && target <= nums[high] ){ //if num is lying on right side
                    low=mid+1;   //adjust the low
                }else{
                    high=mid-1;  //adjust the high
                }               
            }
        }
        return -1;
    }
};
