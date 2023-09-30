# Time Complexity : O(log n) - We are always discarding half of the range
# Space Complexity : O(1) since we did not introduce any auxiliary storage, only hi, low and mid ptrs
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach in three sentences only
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        low = 0
        hi = len(nums) - 1

        while (low <= hi):
            mid = low + (hi - low) // 2

            # if target found at mid, return
            if nums[mid] == target:
                return mid

            # Check if LHS is sorted
            if nums[low] <= nums[mid]:
                if (nums[low] <= target) and (target < nums[mid]):
                    hi = mid - 1  # if tgt lies on LHS, discard RHS
                else:
                    low = mid + 1  # else discard LHS
            else:
                # RHS is sorted
                if (target > nums[mid] and (target <= nums[hi])):
                    low = mid + 1  # if tgt lies on RHS, discard LHS
                else:
                    hi = mid - 1  # else discard RHS
        return -1  # if target not present in the array, return -1


obj = Solution()
print(obj.search([4, 5, 6, 7, 0, 1, 2], 2))
