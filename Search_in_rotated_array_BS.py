''' 
//Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yea while coding I have faced the issue of understandig the logic of checking the target with the leftmost and the mid same for right. I am trying these for first time so this might be the issue


// Your code here along with comments explaining your approach in three sentences only
followed the approach of binary search and then we are checking the left element with the mid along with target for knowing whether to know the target is in sorted part or not.
'''
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left_index = 0
        right_index = len(nums) -1
        while left_index <= right_index:
            mid_index = (left_index + right_index) // 2
            mid_number = nums[mid_index]
            #checking if the mid_number is equal to the target
            if mid_number == target:
                return mid_index
            #leftsorted arrray
            if nums[left_index] <= mid_number:
                if target < nums[left_index] or target > mid_number:
                    left_index = mid_index + 1
                else:
                    right_index = mid_index - 1
            #rightsorted array
            else:
                if target > nums[right_index] or target < mid_number:
                    right_index = mid_index-1
                else:
                    left_index = mid_index +1
        return -1