# Time Complexity: O(logn): This is because each time half of the search space is reduced. We are using Binary Search for it
# Space Complexity: O(1)

# We are using the principle that in a rotated sorted array, atleast one side is sorted.

# Then we first check if the Left is sorted. If the Left side is sorted and the target lies in the range of Low and Mid, we decrease High and do binary search in that half
# Otherwise, we can directly go the the right side

# In a similar fashion we check if the right side is sorted and do the same operation.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # leftissorted
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
