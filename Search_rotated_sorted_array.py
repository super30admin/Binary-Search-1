# // Time Complexity : O(lon(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # check left is sorted
                # check if element is in left side
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right side is sorted
                # check if element is in the right side
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
