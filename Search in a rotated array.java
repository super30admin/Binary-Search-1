// class Solution:
//     def search(self, nums: List[int], target: int) -> int:
//         low = 0
//         high = len(nums) - 1
        
//         while low <= high:
//             mid = (low + high) // 2
            
//             if nums[mid] == target:
//                 return mid
            
//             elif nums[mid] >= nums[low]:
//                 if target >= nums[low] and target < nums[mid]:
//                     high = mid - 1
                
//                 else:
//                     low = mid + 1
                
//             else:
//                 if target > nums[mid] and target <= nums[high]:
//                     low = mid + 1
//                 else:
//                     high = mid - 1
//         return -1


// Time Complexity : O(logn) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: Although the array is rotated I have introduced additional checking
// which looks which of the part is sorted and then traverses accordingly
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high){
            int mid = low + (high - low) / 2;
                
            if (nums[mid] == target)
                return mid;
            
            else if (nums[mid] >= nums[low]){
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            
            else{
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return -1;
    }
}