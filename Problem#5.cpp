
class Solution {
 
public:
    int search(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size()-1;
        
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] >= nums[start])
              {
                if (target >=nums[start] && target < nums[mid]) 
                    end = mid -1;
                else 
                    start = mid+1;
              }
            else
              {
                if (target < nums[end] && target > nums[mid])
                    start = mid +1;
                else 
                     end = mid -1;
             }
        }
        
        return -1;
    }
};

