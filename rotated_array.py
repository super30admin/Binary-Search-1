# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# Difficulties: Building logic for getting sorted part

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l = 0
        h = n - 1
        while (l <= h):
            mid = l + (h - l) // 2
            if nums[mid] == target:
                return mid
            # left of mid
            elif nums[mid] >= nums[l]:
                if nums[mid] > target and nums[l] <= target:
                    h = mid - 1
                else:
                    l = mid + 1
            else:
                if nums[mid] < target and target <= nums[h]:
                    l = mid + 1
                else:
                    h = mid - 1
        return -1