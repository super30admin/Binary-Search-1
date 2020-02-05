// Time Complexity : O(log N) binary search
// Space Complexity : O(log N) for recursive solution (call stack) and O(1) for iterative
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

/*
1. Find which side of the array is sorted
2. Then, check on which side of the array the target is and update low or high accordingly
3. Perform binarySearch on new low and high values
*/

//======================== Recursive solution ===============================

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        return binarySearch(nums, low, high, target);
    }
    
    private int binarySearch(int[] nums, int low, int high, int target) {
        if(low > high) return -1;
        
        int mid = low + (high-low)/2;
        if(nums[mid] == target) return mid;
        //left half is sorted
        else if(nums[low] <= nums[mid]) {
            //target on sorted side
            if(nums[low] <= target && target <= nums[mid])  high = mid-1;
            //target on unsorted side
            else low = mid+1;
        }
        // right half is sorted
        else if(nums[mid] <= nums[high]) {
            //target on sorted side
            if(nums[mid] <= target && target <= nums[high]) low = mid+1;
            else high = mid-1;
        }
        return binarySearch(nums,low,high,target);
    }
}

// ============================== Iterative solution ================================

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        //Update low and high to find the target's side of the array
        while (low <= high) {
            
            int mid = low + (high-low)/2;
            if(nums[mid] == target) 
                return mid;             // target is at index mid
            else if(nums[low] <= nums[mid]) { 
                //left side is sorted and target on sorted side
                if( nums[low] <= target && target <= nums[mid]) high = mid-1;
                //left side is sorted and target not on sorted side
                else low = mid+1;       
            }
            else if(nums[mid] <= nums[high]) {
                //right side is sorted and target on sorted side
                if(nums[mid] <= target && target <= nums[high]) low = mid+1;
                //right side is sorted and target not on sorted side
                else high = mid-1;
            }
        }
        return binarySearch(nums,low,high,target);
    }
    
    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) 
                return mid;
            else if(nums[mid] >= target) 
                high = mid-1;
            else 
                low = mid+1;
        }
        return -1;
    }
}


// =============================== Before class ================================

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        // Find pivot using binary search
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(nums[mid] > nums[hi]) lo = mid+1;
            else hi = mid;
        }
        int rot = lo;
        lo = 0; hi = nums.length-1;
        // Calculate real mid value by adding pivot to mid and perform binary search on the array
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            int real = (mid+rot)%nums.length;
            if(nums[real] == target) return real;
            if(nums[real] < target) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }
}