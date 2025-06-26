# Time Complexity : O(log n)
# Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
#1. We use binary search to find the target in a rotated sorted array.
#2. We check if the left side of the array is sorted and if the target lies
#3. If the right side is sorted, we check if the target lies in that range and adjust the pointers of high and low accordingly.




class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)/2
            #if the target is at mid, return mid position 
            if target==nums[mid]:
                return mid
            #left side sorted
            elif nums[low]<=nums[mid]:
                #check if target lies in the left side sorted array
                #if it does, reduce the high pointer to mid-1, else increase the low pointer to mid+1
                if nums[low]<=target and nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            #right side sorted
            else:
                #if it does, increase the low pointer to mid+1, else reduce the high pointer to mid
                if nums[mid]<target and nums[high]>=target:
                    low=mid+1
                else:
                    high=mid-1
        #if the target is not found, return -1
        return -1
