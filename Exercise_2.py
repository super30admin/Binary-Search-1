#Time Complexity : O(logN), N being the length of array.
#Space Complexity : O(N), N being the length of array.
#Did this code successfully run on Leetcode : Yes. 
#Any problem you faced while coding this : Got tripped up on the recursion part. Solidifying 
#that binary search only takes one side helped in the end. 


#Your code here along with comments explaining your approach in three sentences only
'''Used binary search with recursion while taking into account the case where the array
section is not perfectly ascending.
'''
class Solution:
    def searchArray(self, nums, target, low, high):
        mid = int((low+high)/2)
        # if length of array section is 2 or less, return the index of target, or -1. 
        if high-low<=1:
            if target == nums[low]:
                return low
            if target == nums[high]:
                return high
            else:
                return -1 
        # if low and mid value surround the target, or, if the left value is greater, if target is out of range, take search in low:mid.
        # else, search mid:high 
        elif (nums[low]<=nums[mid] and nums[low]<=target and nums[mid]>target) or (nums[low]>=nums[mid] and (nums[low]<=target or nums[mid]>target)):
            return self.searchArray(nums, target, low, mid)
        else:
            return self.searchArray(nums, target, mid, high)  


    def search(self, nums: List[int], target: int) -> int:
        # to take into consideration if array is empty. 
        if len(nums)==0:
            return -1
        else:
            # use recursion with indices or array. 
            return self.searchArray(nums, target, 0, len(nums)-1)