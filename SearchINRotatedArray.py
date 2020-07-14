#Time Complexity: O(N)
#Space Complexity: O(1)
#Did this code successfully run on Leetcode: Yes


class Solution(object):
    def search(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid

            if nums[mid] <= nums[low]:
                if target in nums[low: mid + 1]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target in nums[mid + 1: high + 1]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
