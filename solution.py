
# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

# // Time Complexity : logn
# // Space Complexity :
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

#Iterative

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = int(left + (right - left) / 2)
            if nums[mid] == target:
                return mid

            # find which side is sorted

            # left side?
            if nums[left] <= nums[mid]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1

            # right side?
            else:
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1

