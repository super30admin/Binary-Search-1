//time complexity: O(logn)
//space complexity:O(1)
//approach: first check if nums[left]<=nums[mid], if true, check if nums[left]<=target && target<=nums[mid], if true element is between those values
//solved on leetcode? yes
//problem faced? no, but I need to revise this question again & again or I keep forgetting it.
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l=0;
        int r=nums.size()-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(target==nums[mid])
                return mid;
            if(nums[l]<=nums[mid])
            {
                if(nums[l]<=target && target<=nums[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }
            else
            {
                if(nums[mid]<=target && target<=nums[r])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return -1;
    }
};