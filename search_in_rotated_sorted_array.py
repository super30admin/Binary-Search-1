"""
Check the array is left sorted or right sorted array and then check if the target
is present in the left half or right

Time Complexity: O(log n)
Space Complexity: O(1)
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l, r = 0, len(nums) - 1

        while l <= r:

            mid = (l + r) // 2

            if nums[mid] == target:
                return mid

            # Left sorted
            if nums[l] <= nums[mid]:

                if nums[l] <= target and nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                # Right sorted
                if nums[mid] < target and nums[r] >= target:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1
