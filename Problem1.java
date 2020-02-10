/*
Time: O(LogN)
Space: O(1) 

Passed All Test Cases 

Solution: We find mid of array, and check if the either of left or right side is sorted. Further, we check if the target is in the range of one of those sorted sides. 
Then, we apply binary Search, The whole working is done by shifting low and high of the array accordingly. If target not found, -1 is returned. 
*/


class Solution {
    public int search(int[] nums, int target) {
        //if array is empty 
        if (nums.length == 0 || nums == null) return -1 ; 
        
        //for binary search 
        int l = 0 ; 
        int h = nums.length - 1 ;
        
        while ( l <= h) {
            int mid = l + (h - l) / 2 ; 
            
            //if target is at index mid
            if (nums[mid] == target) return mid ;
            
            //check if left side of mid is sorted
            if (nums[l] <= nums[mid]) {
                //if the target lies in the left sorted array
                if (target >= nums[l] && target <= nums[mid]) h = mid - 1 ;
                else                
                l = mid + 1 ;
            } else { //the right side is sorted  
             //check if the target is in the right sorted array range 
                if (target >= nums[mid + 1] && target <= nums[h]) l = mid + 1 ;
                else
                    h = mid - 1 ; 
            }

            }
            //if not found
        return -1 ; 
    }
}