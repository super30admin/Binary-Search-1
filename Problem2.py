## Problem2
# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/description/)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            
            # check which part is sorted
            # left sorted
            if nums[low] <= nums[mid]:
                # if target is within the left sorted part
                # bring high to mid - 1 and run binary search on it
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else: # else seaerch on right
                    low = mid + 1
            # right sorted
            else:
                # if target is within the right sorted part
                # bring low to mid + 1 and run binary search on it
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else: # else search on left
                    high = mid - 1
        return low if nums[low] == target else -1