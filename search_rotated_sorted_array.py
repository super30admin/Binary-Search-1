# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""This code uses a slightly modified version of binary search. If the mid is not the number we are looking for, 
I try to see what side of mid is sorted, and then check if the target is between the lower and the higher element of that sorted subarray.
If it is, I'll change high or low in that direction , if not I'll change the high or low in the opposite direction."""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low+high)//2
            if target == nums[mid]:
                return mid

            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                 
        return -1