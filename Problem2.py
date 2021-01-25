"""
Search in Rotated Sorted Array
Time Complexity - O(log n) where n is length of list
Space Complexity - O(1)"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        while(low <= high):
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[low]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target <= nums[high] and target > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
                
        return -1