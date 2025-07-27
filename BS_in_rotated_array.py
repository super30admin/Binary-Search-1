#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low=0                 #start from index 0 as low index
        high=len(nums)-1      #start from lat index as the high index

        while low<=high:      #while there are still parts to search
            mid=low+(high-low)/2 # get the mid index
            if nums[mid]==target: # check if mid is the target
                return mid        # return the mid index
            if nums[low]<=nums[mid]:   #left sorted array
                if nums[low]<=target and nums[mid]>target:#target here 
                    high=mid-1         # change the range 
                else:
                    low=mid+1
            else:                      #right sorted array
                if nums[mid]<target and nums[high]>=target: #target here
                    low=mid+1         # change the range 
                else:
                    high=mid-1
        
        return -1                    # if out of the loop target is not present 
        