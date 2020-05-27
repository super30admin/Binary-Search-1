// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach.
class SearchRotatedArray {
    /**
     * Find the mid and check which half is sorted and if the target belongs to that half - call binary search on it else repeat the same for the other half
     * @param nums
     * @param target
     * @return index of the target if found else -1
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left=0,right=nums.length-1,mid = 0;
        while(left <= right){
            mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid])                    //left - mid is sorted
            {
                if(target <= nums[mid] && target >= nums[left])
                    return find(nums,target,left,mid);
                else
                    left = mid+1;
            }else{                                              //mid-right is sorted
                if(target >= nums[mid] && target <= nums[right])
                    return find(nums,target,mid,right);
                else
                    right = mid-1;;
            }
        }
        return -1;
    }

    /**
     * Normal Binary Search, find mid of the array and if target is at the mid return it else chk if it lies in either half and repeat the procedure
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return index of the target if found else return -1
     */
    public int find(int[] nums, int target, int left, int right){
        if(nums == null || nums.length == 0)
            return -1;
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid] == target)                                           // target is at mid position
                return mid;
            else if(target > nums[mid] && target <= nums[right])             // target is in right half
                left = mid+1;
            else                                                            // target is in left half
                right = mid-1;
        }
        return -1;
    }
}