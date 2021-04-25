// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class RotatedArray {
    public int search(int[] nums, int target) {
        //checking for empty array
        if(nums==null || nums.length==0) return -1;
        // call binary search on our search space
        return binarySearch(nums, target, 0,nums.length-1);
    }
    // returns index of the target and -1 if not found
    private int binarySearch(int[] nums, int target, int low, int high){
        //if search space is valid
        if(low<=high){
            //calculating mid
            int mid = low+(high-low)/2;
            //return mid if target found
            if(nums[mid]==target)return mid;
            //if left sub-array is sorted
            else if(nums[low]<=nums[mid]){
                //if target in left sub array
                if(nums[low]<=target && nums[mid]>target){
                    high = mid-1;

                }
                // if target not in left sub-array
                else{
                    low = mid+1;
                }
            }
            //if left sub-array not sorted
            else{
                //if target in right sub-array
                if(nums[high]>=target && nums[mid]<target){
                    low = mid+1;
                }
                //if target not in right sub-array
                else{
                    high = mid-1;
                }
            }
            //calling binary search for new search space
            return binarySearch(nums, target, low, high);
        }


        return -1;
    }
}