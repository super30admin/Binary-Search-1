# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this: i faced problem in building nested If statement [missed equal to sign]

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int(low + (high - low) / 2)
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                print("ELSE")
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
