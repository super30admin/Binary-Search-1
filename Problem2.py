# Problem 2 : Search in Rotated Sorted Array
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
'''
None
'''
# Your code here along with comments explaining your approach in three sentences only
from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # edge case where matrix is None or length is 0 then return -1
        if nums == None or len(nums) == 0:
            return -1
        # set low to 0 and high to last element of the nums
        low = 0 
        high = len(nums) - 1
        # loop till low > high
        while (low <= high):
            # find middle element between low and high
            mid = low + (high - low) // 2
            # if the value at mid position is equal to target then we found the element and return index
            if target == nums[mid]:
                return mid
            # else if check if the left part is osrt by comparing nums at low and middle position
            elif nums[low] <= nums[mid]:
                # if it is sorted then check if target is in range from nums[low] and nums[mid]
                if nums[low] <= target and target <= nums[mid]:
                    # if it is then set high to middle - 1
                    high = mid - 1
                else:
                    # set the low to middle + 1
                    low = mid + 1
            # else the right part of the array is sorted
            else:
                # then check if the target is in range nums[mid] and nums[high]
                if nums[mid] <= target and target <= nums[high]:
                    # if it then set low to mid + 1
                    low = mid + 1
                else:
                    # set high to mid - 1
                    high = mid - 1
        # if at all the target is not found then return -1 
        return -1