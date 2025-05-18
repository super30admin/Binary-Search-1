# Time Complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def search(self, nums, target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # left sorted array
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right sorted array
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1