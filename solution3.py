# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums, target) -> int:
        start, end = 0, len(nums) - 1
        #start binary search
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return mid
            # non-rotated section
            elif nums[mid] >= nums[start]:
                if target >= nums[start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            # rotation between start and mid
            else:
                if target <= nums[end] and target > nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1