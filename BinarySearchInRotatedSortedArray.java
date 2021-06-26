// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :


class BinarySearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        //null check and length zero
        if(nums == null || nums.length == 0)
            return -1;
        //calculate low & high
            
         int low = 0, high = nums.length-1;
        
        //Binary Search
        while(low <= high){
            //if we do (low+high)/2, we might get iner overflow exception for some edge cases
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
                return mid;
            
    //in the rotated array ,you will a pattern that one side from mid id sorted and other is not
    //To find which side is sorted- left or right?
            
            //left side sorted
            if(nums[low] <=nums[mid]){
         //check target on sorted side or target on unsorted side
                if(nums[low] <= target && nums[mid] > target){
                    high = mid -1;
                }else
                    low = mid+1;
            }
            //right side sorted
            else if(nums[mid] <= nums[high])
            {
         //check target on sorted side or target on unsorted side
            if(nums[mid] < target && nums[high] >=target){
                low = mid +1;
            }
            else
                high = mid -1;
        }
        }
        return -1;   
    }
}






