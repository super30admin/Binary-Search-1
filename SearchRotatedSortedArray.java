// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * I have used Linear Search to find the element
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
            return i;
        }
        return -1;
    }
}




// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * I have used Binary Search to eliminate half of the array each time and limit the search space
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        int low = 0,high = nums.length -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            // array is already sorted and target is not in the array
            if(nums[low] <= nums[high] && nums[high] < target)
                return -1;
            // target at mid
            if(nums[mid] == target)
                return mid;
            // left array is sorted
            else if(nums[low] <= nums[mid] ){
                if(target >= nums[low] && target < nums[mid])
                    high = mid-1;
                else
                    low = mid + 1;
            }
            else {
            if(nums[mid] <= nums[high]){     
                if(target > nums[mid] && target <= nums[high])         
                low = mid + 1;
                else
                high = mid-1;
            }
        }
        }
        return -1;
    }
    
}
