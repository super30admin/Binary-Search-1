
"""
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
For this question, we will be taking low as 0 and high as length of array-1, just like in any binary search. 
We will divide the array in 2 halves, check which part of the array is sorted. If left part is sorted, we will
check if target is in range. If not, we will change the values of low and high accordingly.
If right part is sorted, we will check for target's range again. According to the ranges, we will again 
change values. We will keep on repeating this process unless we find our target or low<=high.
If none of the condition is valid, we will return -1
"""


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            elif mid == low or nums[low] < nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
            elif mid == high or nums[mid] < nums[high]:
                if nums[mid] < target <= nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1
