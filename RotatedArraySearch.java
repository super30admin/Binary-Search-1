// Time Complexity : O(log(n)) n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class RotatedArraySearch {
    /*
    So at all times atleast one half of the array is sorted. we see if ele is present in sorted or unsorted half.
    If its in sorted half we increase low or high as per the normal binary search.
    If its in the un sorted half we swap the low and high as per usual.
    @param: nums, target
    @return pos of target or -1 if not found
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            } else if(nums[high]>=nums[mid]){
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedArraySearch rotatedArray = new RotatedArraySearch();
        int [] arr = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(rotatedArray.search(arr,target));
        target = 0;
        System.out.println(rotatedArray.search(arr,target));
        target = -1;
        System.out.println(rotatedArray.search(arr,target));
    }
}