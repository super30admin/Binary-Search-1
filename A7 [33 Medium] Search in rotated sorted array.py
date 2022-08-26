# Time complexity= O(log n)
# Space Complexity= O


class Solution:
    def search(self, nums: [int], target: int) -> int:

        if nums is None:
            return -1

        low = 0
        high = len(nums) - 1
        print(high)

        while (low <= high):
            mid = low + ((high - low) >> 1)  # locating mid

            if nums[mid] == target:
                return mid

            # left Sorted
            if (nums[low] <= nums[mid]):
                if (nums[low] <= target and nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1

            # right sorted
            else:
                if (nums[mid] < target and nums[high] >= target):
                    low = mid + 1
                else:
                    high = mid - 1

        return -1

