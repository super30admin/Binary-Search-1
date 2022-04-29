/**

Time Complexity : O(logN)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : The boundary Conditions, 
the code kept on breaking at boundary condition for few submissions
**/
class SearchInRotatedArray 
{
    private final int NOT_FOUND = -1;

    public int search(int[] nums, int target) 
    {
        if(nums == null || nums.length ==0)
            return NOT_FOUND;
        
        int low = 0;
        int high = nums.length -1;

        
        while(low <= high)
        {
            int mid = low + (high -low)/2;
            
            if( nums[mid] == target)
                return mid;
            else
            {   
                if(nums[low] == target)
                    return low;
                if(nums[high] == target)
                    return high;
                
                boolean isLeftPartSorted = nums[low] <= nums[mid];

                
                if(isLeftPartSorted)
                {
                    boolean targetLiesInLeftPart = target > nums[low] && target <nums[mid];
                    if(targetLiesInLeftPart)
                        high = mid -1;
                    else
                        low = mid + 1;
                }// end of left part sorted block
                else
                {
                    boolean targetLiesInRightPart = target < nums[high] && target > nums[mid];
                    if(targetLiesInRightPart)
                        low = mid + 1;
                    else
                        high = mid - 1;
                }// end of right part sorted block

            }

        }

        return NOT_FOUND;
    }
}