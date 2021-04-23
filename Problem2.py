# Search in Rotated Sorted Array

''' Time complexity : O(log N) 
Space Complexity: O(1)
Did this code successfully run on Leetcode :    Yes
Any problem you faced while coding this: No 

approach find mid element. check which part is sorted . and see if element lies in that part else 
the element will be in the unsorted part'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[low]:
                ##right side is sorted
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                    #low side is sorted
            else:
                if target <= nums[high] and target > nums[mid]:
                     low = mid + 1
                else:
                    high = mid - 1
        return -1
        
