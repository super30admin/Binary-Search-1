# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : No

class Solution(object):
    def search(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            #left sorted
            if nums[mid] == target:
                return mid
            #left sorted
            if nums[low] <= nums[mid]:
               if nums[low] <= target < nums[mid]:
                  high = mid - 1
               else:
                  low = mid + 1
            else: #right sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

        