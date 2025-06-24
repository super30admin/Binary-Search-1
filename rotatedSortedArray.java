// Time Complexity : O(log n) since we are using binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
// I used binary search to find the target in a rotated sorted array.  
// In each step, I checked which half (left or right) of the array is sorted.  
// Then I decided whether to search in that half or the other half based on where the target could lie.


public class rotatedSortedArray {
    public int search(int[] nums, int target){
        if(nums.length==0 || nums == null)
            return -1;
        
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }


            }
            else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }

        }

        return -1;

        



    }

    public static void main(String[]args){
        rotatedSortedArray r = new rotatedSortedArray();
        int[] nums = new int[]{6, 7, 0, 1, 2, 5};
        System.out.println(r.search(nums, 7));

    }

    
}
