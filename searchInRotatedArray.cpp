// Time Complexity : O(logn) 
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: FIRST FIND PIVOT USING BS SINCE BOTH SIDES OF PIVOT ARE SORTED

// 1. Find pivot as the abnormal element, left and right are not small and big respectively
// 2. Pivot also found using BS - always search in unsorted side
// 3. Search on left/right of pivot depending on where target lies 


class Solution {
public:
    // find pivot element; both sides of pivot will be sorted so normal BS can be done later
    // to find pivot, find if mid is abnormal
    // if mid is normal then search in unsorted side
    int search(vector<int>& nums, int target) {
        if(nums.size()==0)
            return -1;
        int low = 0, high = nums.size()-1,mid=-1,pivot=-1;
        
        while(low<=high){
            mid = low +(high-low)/2; // to avoid overflow
            // not a pivot
            if((mid-1>=low && nums[mid]>nums[mid-1]) && (mid+1<=high && nums[mid]<nums[mid+1])){
                if(nums[mid]<nums[high]) // right is sorted, search pivot in left
                    high = mid-1;
                else
                    low = mid+1;
            }
            else{ // pivot found
                pivot = mid;
                break;
            }
        }
        cout<<pivot;
        // low high would have changed, reset them
        low = 0; high = nums.size()-1;
        
        // both sides of pivot are sorted; search accordingly
        if(nums[pivot] == target)
            return pivot;
        else if(target>=nums[low] && pivot-1>=0 && target<=nums[pivot-1]) // search in left array
            return bs(nums,low,pivot-1,target);
        else // search in right array
            return bs(nums,pivot+1,high,target);
    }
    
    int bs(vector<int>& nums, int left, int right, int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(target<nums[mid]) // search in left
                right = mid-1;
            else // search in right
                left = mid+1;
        }
        return -1;
    }
};