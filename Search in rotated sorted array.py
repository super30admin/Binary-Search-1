# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : explained in class

class Solution:
    def search(self, nums, target):
        l, r = 0, len(nums) - 1

        while l <= r:
            mid = (l + r) // 2

            # if the target is found, then return
            if target == nums[mid]:
                return mid

            # left sorted portion of the array
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1

            # right sorted portion of the array
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1

        return -1