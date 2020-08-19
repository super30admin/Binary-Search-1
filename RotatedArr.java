// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
We search in either rotated or non- rotated array based on the target.
In every iteration, we adjust wither high or low so that search is closer to target.

*/
class RotatedArr {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int mid = 0;
        while(low <= high ){
            mid = low + (high-low)/2;
            System.out.println(mid);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>=nums[low]){
                if(target>=nums[low] && target < nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid +1;
                }
            }
            else{
                if(target<=nums[high] && target > nums[mid]){
                    low = mid +1;
                }
                else{
                    high = mid -1;
                }
            }
        }
        return -1;
        
    }
}