# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: NO

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        
        if nums == None or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) -1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid
            
            # left sorted case
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid -1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1