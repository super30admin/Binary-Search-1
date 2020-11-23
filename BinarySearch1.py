# Time complexity: O(log(n))
# Space Complexity: O(1) 
# Approach: Binary search; if nums[low] <= nums[mid] -> if target lies between them, high = mid - 1 else low = mid + 1 and check if target lies between mid and high,
# if yes, increment low else decrement high. Main if condition is to search if element lies in rotated part or in normal part.

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if not nums:
            return -1

        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if target == nums[mid]:
                return mid

            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1