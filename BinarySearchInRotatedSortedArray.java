// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :


class BinarySearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        //null check and length zero
        if(nums == null || nums.length == 0)
            return -1;
        //calculate low & high

        int low = 0, high = nums.length-1;

        //Binary Search
        //Will come out of while loop when target is found or when Low gets shifted past the High/(meaning target not found in the array)
        while(low <= high){
            //if we do (low+high)/2, we might get iner overflow exception for some edge cases
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
                return mid;

            //in the rotated array ,you will a pattern that one side from mid is sorted and other is not
            //We can do binary search on sorted array
            //To find which side is sorted- left or right?

            //left side sorted
            if(nums[low] <=nums[mid]){
                //check target on sorted side or target on unsorted side or Comparing if target is within the low & the mid
                if(nums[low] <= target && nums[mid] > target){
                    high = mid -1;
                }else
                    low = mid+1;
            }
            //right side sorted
            else if(nums[mid] <= nums[high])
            {
                //check target on sorted side or target on unsorted side or we can say comapring if target is within mid and high
                if(nums[mid] < target && nums[high] >=target){
                    low = mid +1;
                }
                else
                    high = mid -1;
            }
        }
        return -1;
}






