
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Approach:  Modified binary search
//      find aprropriate subpart of array which is sorted and check if target might lie in that range:
// .   - if yes, apply binary search in that subpart
// .   - else look into other subpart


class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        if( nums.size() == 0){
            return -1;
        }
        int low = 0;
        int high= nums.size()-1;
        
        while( low <= high){
            
            int mid = low + (high -low)/2;
            if(nums[mid]== target){
                return mid;
            }
            
            //since entire array isnt sorted, check for sorted part
            
            //check if left sorted
            if( nums[low ] <= nums[mid]){
                
                //check if target in left range
                if( nums[low] <= target && nums[mid] >= target ){
                    high= mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                //right sorted
                
                //check if target in right range
                if ( nums[mid] <= target && nums[high] >=target){
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