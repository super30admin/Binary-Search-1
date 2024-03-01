 /** Time Complexity: O(log n)
    Space Complexity: O(1)
    Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
  */

/**Approach
There are 2 parts of the array:
At any given point of time, at least 1 part of the array would be sorted 
So either it would be be left-sorted or right-sorted.
Step 1: Calculate mid, check if arr[mid] = target, if so return mid index 
      If not
Step : Check if your array is left sorted, how?
Ans: if arr[low] <= arr[mid] (if it is then it is left sorted) 
        check if the element is present in the left sorted array
        (arr[low] <= target && arr[mid] > target)
        then high = mid-1
        else
        low = mid+1

Step : Check if your array is right sorted, how?
Ans: if arr[high] > arr[mid] (if yes it is right sorted) 
        check if the element is present in the right sorted array
        (arr[hight] >= target && arr[mid] < target)
        then low = mid+1
        else
        high = mid-1        
*/

class Solution {
    public int search(int[] nums, int target) {
        //null
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length -1 ;

        while(low < high)
        {
            int mid = low + (high - low)/2; //to avoid interger overflow

            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && nums[mid] > target)
                    {
                        high = mid;
                    }
                else{
                        low = mid+1;
                    } 
            }
            else
            { //right sorted
                if(nums[high] >= target && nums[mid] < target)
                {
                    low = mid + 1;
                }
                else{
                    high = mid;
                    } 
            }
        } 
        if(nums[low] == target) return low;
    return -1;
    }
}