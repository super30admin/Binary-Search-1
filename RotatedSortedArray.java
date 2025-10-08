/*
Time Complexity: O(log(n))
Space Complexity : O(1)

Approach: Implementing binary search to find the value as we can reduce the search size by half with this approach
 */
public class RotatedSortedArray {
    // Declare instance variables
    private int low;
    private int high;
    private int mid;
    public int search(int[] nums, int target) {
        // Initialize the instance variables declared above
        low =0 ;
        high = nums.length-1;
        mid = 0;

        // Initialise the while loop with break condition low<=high to implement binary search
        while(low <= high){
            //Calculate mid value
            mid = low + (high-low) / 2;
            // If value at index mix is target return mid
            if(nums[mid] == target) return mid;
            // Reducing the search by half
            else{
                // If left side of mid is sorted
                if(nums[low] <= nums[mid]){
                    // And target lies in left side
                    if(nums[low] <= target && nums[mid] >= target) high = mid-1;
                    // Remove right side
                    else low = mid+1;
                }
                // Right side is sorted
                else{
                    //If target lies in right side remove left half
                    if(nums[mid] <= target && nums[high] >= target) low = mid+1;
                    // If not it should be left half so remove right half
                    else high = mid-1;
                }
            }
        }
        return -1;
    }
}
