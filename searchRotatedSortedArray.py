# Time: O(logn)
# Space: O(logn)
# run successfully on leetcode: yes
# Approach:
# if left sub array is ascending and target lies in it, then move the right to mid-1. else move left to mid + 1
# if right sub array is ascending and target lies in it, then move left to mid + 1, else move right to mid - 1
# here the else deals with 2 cases which needs same treatment i.e move left to mid or right to mid accordingly.
# termination case would be when target is found or left > right.

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        strt, end = 0, len(nums)-1
        while strt <= end:
            mid = strt + (end-strt)//2
            if nums[mid]==target:
                return mid
            elif nums[strt]<=nums[mid]:
                if target>=nums[strt] and target<nums[mid]:
                    end = mid-1
                else:
                    strt = mid+1
            else:
                if target<=nums[end] and target>nums[mid]:
                    strt=mid+1
                else:
                    end=mid-1
        return -1