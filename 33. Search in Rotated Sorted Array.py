# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : While checking for left/right sorted part, was comparing with mid+1 rather than mid

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        In a rotated sorted array, one half will always be sorted.
        Use the above logic to apply in binary search.
        """
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]: #left sorted
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[mid] <= nums[high]:     #right sorted
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1 
        