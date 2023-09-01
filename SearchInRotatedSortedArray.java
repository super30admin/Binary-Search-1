// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

//Question: 33. Search in Rotated Sorted Array

//Binary seacrh but the catch is array is not sorted, find the mid, since nums is possibly rotated at an unknown pivot index k, you will notice that
// from the mid either left or right side or array will already be sorted


class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
           int mid = low + (high-low)/2;

           //check if mid is the target
            if(nums[mid] == target){
                return mid;
            }
            //check if left to mid array is sorted
            if(nums[low] <= nums[mid]){
                //check if target is between low and mid
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                //check if target is between mid and high
                if(nums[high] >= target && nums[mid] < target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}


// Driver code 
class Main { 
    public static void main(String args[]) 
    { 
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search.search(nums, target);
        System.out.println(result);
    } 
}