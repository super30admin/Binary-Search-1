import javax.lang.model.util.ElementScanner6;

// Time Complexity :O(1)
// Space Complexity :O(logn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
public class SearchInRotatedSortedArray {

    public int search(int nums[], int target)
    {
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length-1;

        while(low <= high)
        {
            int mid = low + (high - low)/2; // to avoid integer overflow

            if(nums[mid] == target)
                return mid;
            
            if(nums[low] <= nums[mid]) // sorted left half
            {
                if(nums[low] >= target && nums[mid] <= target) // if target lies inside the left sorted range
                {
                    high = mid-1; // search inside the left sorted half
                }
                else
                {
                    low = mid + 1; 
                }
            }
            else
            {
                if(nums[mid] <= target && nums[high] >= target) // if target lies inside the right sorted range
                {
                    low = mid + 1; // search inside the right sorted half
                }
                else
                {
                    high = mid-1;
                }
                
            }
        }
    }
}
