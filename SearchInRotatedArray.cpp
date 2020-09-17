// Time Complexity : log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
public:
    
    int bsearch(vector<int>nums,int target,int start,int end)
    {
        if(start>end)
            return -1;
        
        int mid=start+(end-start)/2;
        
        if(nums[mid]==target)
            return mid;
        
        //cout<<nums[start]<<" "<<nums[mid]<<" "<<nums[end]<<endl;
        
        if(nums[start]<=nums[mid])//the first half is sorted
        {
            if(nums[start]<=target && nums[mid]>=target)
              return bsearch(nums,target,start,mid-1);
            
            return bsearch(nums,target,mid+1,end);
        }
        if(nums[mid]<=nums[end])//the second half is sorted
        {
            if(nums[mid]<=target && nums[end]>=target)
                return bsearch(nums,target,mid+1,end);
            
            return bsearch(nums,target,start,mid-1);
        }
        
        return -1;
    }
    
    int search(vector<int>& nums, int target) {
     return bsearch(nums,target,0,nums.size()-1);   
    }
};