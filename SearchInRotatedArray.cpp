// Time Complexity : Log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Use binary search.
 *
 * After calculating mid, one side of array is always going to be sorted. 
 * Use sorted side of array to make decision whether to search element in sorted side or unsorted side. 
 *
 */
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.size() == 0)
            return -1;
        
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            
            if (nums[mid] == target)
                return mid;
            
            if (nums[low] <= nums[mid])
            {
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else
            {
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
};