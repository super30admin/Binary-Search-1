# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1
        # We will find the mid and see if it is equal to the mid value.
        # If it is equal, we will return the index.
        while l<=r:
            mid = l+(r-l)//2
            if nums[mid]==target:
                return mid
            #left portion
            # we will see if the mid is greater than or equal to the element at the left pointer.
            # If it is, then we will check if the target is greater than mid or target is lesser than the value at left pointer
            # if it is, we will shift the left pointer to the next place of mid.
            # If it is not, then we will shift the right pointer to the place left to the mid.
            if nums[l]<=nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid+1
                else:
                    r = mid-1
            #right portion
            # If the mid is not greater than or equal to the element at the left pointer,
            # then we will check if the target is lesser than mid or target is greater than the value at right pointer
            # if it is, we will shift the right pointer to the left of mid.
            # If it is not, then we will shift the left pointer to the place right to the mid.
            else:
                if target < nums[mid] or target>nums[r]:
                    r = mid-1
                else:
                    l = mid+1
        # if we don't find the target after traversing the whole array, we will return one.
        return -1