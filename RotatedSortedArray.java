//Passed all test cases
/*
    TC - O(logn) where n is size of the given array
    SC - O(1) no extra space used.
    Method - Binary Search - Compare the low and mid, if low element is less than mid element, then the left array is in sorted order. Check if the target element lies in between the low and mid, if so, update the high variable, else update low. If the left split is not in sorted order, the right split will be in sorted order. Check the target element if lies between, update low, else high update. Repeat till low greater than high.
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int low = 0;
        int high = nums.length-1;   
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[low]<=nums[mid]) // sorted left block
            {
                if(target >= nums[low] && target < nums[mid])
                {
                    high = mid -1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                if(target > nums[mid] && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
        
    }
}