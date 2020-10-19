// Time Complexity : o(logn)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class BinarySearch1 {

    public static void main(String[] args) {
        int nums [] = new int[] {4,5,6,7,0,1,2};
        int index = search(nums,0);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        int low =0;
        int high = nums.length - 1;
        int mid;

        //This is binary search. So, need to start a problem with low and high comparison
        while (low <= high) {
            mid = low + (high - low)/2;
            //if the mid element is equal to target, return mid
            if (nums[mid] == target) return mid;

            //else, check if nums[mid] is greater than num[low]
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid -1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}