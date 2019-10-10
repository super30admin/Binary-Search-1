# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Figuring out the test case when its pivoted!

# Your code here along with comments explaining your approach:
# Here I have used Binary Search but with some extra conditions for 
# a this rotated soarted array.

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = (left+right)/2
            if nums[mid] == target:
                return mid
            if nums[left] <= target < nums[mid]:
                right = mid-1
            elif nums[mid] < target <= nums[right]:
                left = mid+1
            elif nums[mid] > nums[right]:
                left = mid+1
            else:
                right = mid-1
        return -1
                
