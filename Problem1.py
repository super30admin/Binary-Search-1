class Solution:
    # Time Complexity: O(log n)
    def search(self, nums: List[int], target: int) -> int:
        if nums is None:
            return -1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = int(low + (high - low) / 2)
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
