class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # Time Complexity :O(logn)
        #Space Complexity :O(1)
        #Did this code successfully run on Leetcode :Yes
        #Any problem you faced while coding this : No
        if(nums==None or len(nums)==0):
            return -1
        
        low= 0 
        high = len(nums)-1
        
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                return mid
            elif(nums[low]<=nums[mid]):
                if(nums[low]<=target and nums[mid]>target):
                    high=mid-1
                else:
                    low=mid+1
            else:
                if(nums[mid]<target and nums[high]>=target):
                    low=mid+1
                else:
                    high= mid-1
        return -1