#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums, target) -> int:
        if nums is None or len(nums) == 0:
            return -1

        size = len(nums)

        left = 0
        right = len(nums) - 1
        # we will find the pivot point, where the array is shifted
        while (left < right):
            mid = (left + right) // 2
            if (nums[mid] > nums[right]):
                left = mid + 1
            else:
                right = mid

        if target >= nums[left] and target <= nums[size - 1]:
            right = size - 1
        else:
            left = 0

        while left <= right:
            mid = (left + right) // 2
            if (nums[mid] > target):
                right = mid - 1
            elif (nums[mid] < target):
                left = mid + 1
            else:
                return mid
        return -1