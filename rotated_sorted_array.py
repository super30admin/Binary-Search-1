# Time Complexity : O(log(n)) as we are using binary search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Implementing Search in Rotated Sorted Array
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        if nums == None or len(nums) == 0:
            return -1
        while low <= high:
            mid = low + ((high - low) // 2) # To avoid the integer overflow
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]: # left part is sorted
                if target >=nums[low] and target < nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1
            else: # right part is sorted
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
