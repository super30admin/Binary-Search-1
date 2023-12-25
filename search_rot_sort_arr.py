class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if (nums is None or len(nums) == 0):
            return -1
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid

            # check which side is sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1

            else:
                # right side is sorted
                if nums[mid] <= target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
