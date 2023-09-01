#  Time Complexity : O(log (n)) where n is the length of the array.
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 
 
 
# - In a Rotated Sorted Array, at least one side of the Array is always sorted. Both can be sorted also.
# - We check the left half. if it is sorted, we check if our target is in that side. If we don’t check for which side is sorted, it will become linear search.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1

        while (low <= high):

            mid = (low + high)//2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]: # left side of middle is sorted
                if nums[low] <= target and target <= nums[mid]:
                    high = mid -1
                else: 
                    low =   mid + 1
            else: # right side of the middle is sorted
                if nums[mid] <= target and target <= nums[high]: 
                    low = mid + 1
                else:
                    high = mid -1
        return -1
