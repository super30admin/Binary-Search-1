"""
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        while (left <= right):
            mid = left + (right - left)//2
            if (nums[mid] == target):
                return mid
            if(nums[left]<= nums[mid]):
                if (nums[left]<= target and target < nums[mid]):
                    right = mid - 1
                else:
                    left = mid+1
            else:
                if(nums[mid]< target and target <= nums[right]):
                    left = mid + 1
                else:
                    right = mid - 1
        return -1