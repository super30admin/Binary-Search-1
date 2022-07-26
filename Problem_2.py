"""
 Time Complexity : O(logn), where n is number of elements
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Yes

 our code here along with comments explaining your approach

 Problem 2 :There is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your function, nums is possibly rotated
            at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
            For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
            Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

            You must write an algorithm with O(log n) runtime complexity.
"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        We will use binary search in this, by dividing the array in sorted and unsorted array.
        First we will check the sorted side and then the unsorted.
        itype: int, int
        rtype = int
        """
        if len(nums) == 0:
                return -1

        low , high = 0, len(nums) - 1

        while (low <= high):
            mid = (low + high)//2

            if nums[mid] == target:
                return mid

            #if right side is sorted
            if (nums[low] <= nums[mid]):
                if (nums[low] <= target and nums[mid] > target):
                    high = mid - 1 
                else:
                    low = mid + 1
            # if left side is sorted
            else:
                if (nums[mid] < target and nums[high] >= target):
                    low = mid + 1 
                else:
                    high = mid - 1
            
        return -1
    
        