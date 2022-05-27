""""// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach"""




class Solution:
    def search(self, nums, target):


        # O(log n)
        left = 0
        right = 1

        # firstly we decide our boundaries for search
        while nums[right] < target:
            left = right
            right *=2


        # now we run our normal binary search

        while left<=right :
            mid = left=(right-left)//2

            if target == nums[mid]:
                return mid

            if target<nums[mid]:
                right = mid-1
            elif target > nums[mid]:
                left = mid+1

        return -1