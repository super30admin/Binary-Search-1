// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//Brut force way with O(N) complexity

// class RotatedSortedArraySearch {
//     public int search(int[] nums, int target) {
//        for(int i=0; i<nums.length; i++) {
//         if(nums[i] == target){
//             return i;
//         }
//        }
//        return -1;
//     }
// }

// Optimal way using Binary Search
class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
       int low = 0, high = nums.length-1;
        while(low <=high) {
             int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low] <= nums[mid]) { //left sorted
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }
}


