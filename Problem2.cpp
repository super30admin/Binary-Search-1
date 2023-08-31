//Time complexity: O(logn) n is number of elements
//space complexity: O(1)
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left=0, right=nums.size()-1;

        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(target==nums[mid])
            {
                return mid;

            }
            if(nums[mid]>=nums[left])
            {
                if(target>=nums[left] and target<=nums[mid])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            else
            {
                if(target>=nums[mid] and target<=nums[right])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
   
    
};