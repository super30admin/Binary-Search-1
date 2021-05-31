class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()==0) return -1;//null
        int low=0;
        int high=nums.size()-1;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;//integer overflow
            if(nums[mid]==target) return mid;
            else if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && nums[mid]>target)
                {
                    high = mid-1;
                }else
                {
                    low = mid+1;
                }
                
            }
            else//right sorted
            {
                if(nums[mid]<target && nums[high]>=target)
                {
                    low=mid +1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
};