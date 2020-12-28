// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes  
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        if(nums.empty()||nums.size()==0) return -1;
        int n = nums.size();
        int low =0;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[low]<=nums[mid])
            {   if(nums[low]<=target && target<nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            
            
            
                
            else{ // right side is sorted
                if(nums[mid]<target && target<=nums[high]){
                    low=mid+1;
                }
                else
                    high=mid-1;                            
            }
        }
            
        return -1;
        
    }
};