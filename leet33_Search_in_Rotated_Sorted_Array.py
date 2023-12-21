# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Need to make sure we use > or >= based on the test cases


# // Your code here along with comments explaining your approach
# Approach is to use Binary search to reduce search space. Using the value of nums[mid] to decide which part of the
# array can be ignored to reduce the search space by half
class Solution:
    def search(self, nums, target):

        low = 0
        high = len(nums)-1

        while low<=high:
            mid = (low+high)//2
            if nums[mid] == target:
                return mid
            elif nums[mid]>=nums[low]:
                if nums[mid] > target and target>=nums[low]:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if nums[high]>=target and target>nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
        
        return -1