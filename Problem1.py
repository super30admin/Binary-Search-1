# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
1. First calculate mid value and check if its equal to target. Then check if the middle value is greater or less than the right value to check which side is sorted
2. If the right side is sorted, check if the target lies between the middle and right value, if yes, move left to mid+1 else move right to mid-1
3. If the left side is sorted, check if the target lies between the left and middle element, if yes, move right to mid-1 else move left to mid+1. Do this until target is found or left<=right
'''

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0 
        right = len(nums)-1

        while(left<=right):
            mid = left+ (right-left)//2
            if nums[mid] == target:
                return mid
            if nums[mid] < nums[right]:
                if nums[mid] < target <= nums[right]:
                    left = mid+1
                else:
                    right = mid-1
            else:
                if nums[left] <= target<nums[mid]:
                    right = mid-1
                else:
                    left = mid+1
        return -1
