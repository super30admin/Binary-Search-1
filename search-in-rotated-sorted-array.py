# // Time Complexity : O(Log N)
# // Space Complexity : O (1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Finding out the point of pivot


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid

            # left sorted portion
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            # right sorted portion
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        return -1
