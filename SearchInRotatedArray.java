// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes. Both implementation did run in LC
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {

        if(nums==null || nums.length ==0){return -1;}
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){return mid;}

            else if(nums[low] <= nums[mid]){ //left or right
                if(nums[low] <= target && nums[mid] > target){
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}


// Another way of implementation
/*
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        int result = binarySearch (nums, target, left, right);
        return result;
    }


    public static int binarySearch(int[] nums, int target, int left, int right){
        if(left > right ){
            return -1;
        }

        int mid = (left + right)/2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[left] < nums[mid]){  // left is normally ordered
            if(nums[left] <= target && target <= nums[mid]){
                return binarySearch(nums, target, left, mid-1);
            }else{
                return binarySearch(nums, target, mid+1, right);
            }
        }else if(nums[mid] < nums[right]){  // right is noramally ordered
            if(nums[mid] < target && target <= nums[right]){
                return binarySearch(nums, target, mid+1, right);
            }else{
                return binarySearch(nums, target, left, mid-1);
            }
        }else{
            int location = -1;
            if(nums[left] == nums[mid]){
                location = binarySearch(nums, target, mid+1, right) ;
            }

            if(location ==-1 && nums[mid] == nums[right]){
                location = binarySearch(nums, target, left, mid-1);
            }
             return location;
        }

    }
}
 */
