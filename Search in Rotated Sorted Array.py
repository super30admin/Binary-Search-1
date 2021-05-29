# Space Complexity : O(1)
# Time Complexity : O(log N)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach


class Solution:
    def search(self,nums: List[int], target: int) -> int:
        if not nums:
            return -1
        elif len(nums) == 1 and nums[0] != target:
            return -1
        elif nums[0] == target:
            return 0
        start, end = 0, len(nums) - 1

        while start < end:
            mid = int((start + end) / 2)
            if nums[mid] > nums[start]:
                start = mid
            else:
                end = mid

        index = start + 1
        start = 0
        end = len(nums) - 1

        if nums[index] <= target <= nums[end]:
            start = index
        else:
            end = index

        while start <= end:
            mid = int((start + end) / 2)
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1


