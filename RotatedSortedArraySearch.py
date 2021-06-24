# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        end = len(nums) - 1
        
        # Revised Binary Search
        while low <= end:
            mid = low + (end - low) // 2
            
            if nums[mid] == target:
                return mid
            
            # Sorted Array is in left half
            elif nums[mid] >= nums[low]:
                # Check if target is within the range of sorted array
                if target >= nums[low] and target < nums[mid]:
                    end = mid - 1
                else:
                    low = mid + 1
            
            # Sorted Array is in right half
            else:
                # Check if target is within the range of sorted array
                if target <= nums[end] and target > nums[mid]:
                    low = mid + 1
                else:
                    end = mid - 1
                    
        return -1