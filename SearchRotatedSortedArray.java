// Time Complexity :O(log(n)) where n = length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        //if no elements exist
        if(nums.length==0||nums==null) return -1;

        //initializing low and high
        int low = 0, high = nums.length-1;

        while(low<=high){
            //calculating mid
            int mid = low+(high-low)/2;

            //check if target found
            if(nums[mid]==target) return mid;

            //check if left half sorted
            if(nums[low]<=nums[mid]){
                //check if target exists in left half, update high
                if(nums[low]<=target && target<nums[mid]){
                    high = mid-1;
                }
                //if target exists in right half, update low
                else{
                    low = mid+1;
                }
            }
            //if right half sorted
            else{
                 //check if target exists in right half, update low
                if(nums[mid]<target && target<=nums[high]){
                    low = mid+1;
                }
                //if target exists in left half, update low
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    
}
