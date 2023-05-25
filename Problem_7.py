"""
Problem : 7

Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

First checking whether the left part of the middle index is sorted or not,
and checking whether target falls in that range then performing binary search for left part
otherwise checking the right unsorted side and performing same tasks
"""

class Solution(object):
    def search(self, nums, target):
        l,r=0,len(nums)-1
        mid=(l+r)//2

        while l<=r:
            mid=(l+r)//2
            if target==nums[mid]:
                return mid
            if nums[l]<=nums[mid]:
                if nums[l]<=target and nums[mid]>=target:
                    r=mid-1
                else:
                    l=mid+1

            else:
                if nums[r]>=target and nums[mid]<=target:
                    l=mid+1
                else:
                    r=mid-1

        return -1
