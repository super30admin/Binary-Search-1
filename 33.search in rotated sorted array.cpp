class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l=0;
        int h = nums.size()-1;
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            if (nums[mid]==target) return mid;
            if(nums[l]<= nums[mid]) //left sorted
            {
               if(nums[l]<=target &&nums[mid]>target) // check element is present in sorted array
                 h = mid-1;
                else 
                 l = mid+1;
            }
            else                  //right sorted and check whether element is present
            {
               if(nums[mid]<target && nums[h]>=target)
                l = mid+1;
                else
                h = mid-1;
            }                
        }
        return -1;
    }
};