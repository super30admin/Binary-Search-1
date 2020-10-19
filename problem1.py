// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution(object):
    
    
    
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low=0
        high=len(nums)-1
        #edge case
        if (nums==None or len(nums)==0):
            return -1
        
        while(low<=high):
            mid=low+(high-low)/2
            
            if nums[mid]==target:
                return mid
            #left side of the array is sorted 
            if nums[low]<=nums[mid]:
                if nums[low]<=target and target<nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:# right side is sorted 
                if nums[mid]<target and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
         # return -1 if element is not found        
        return -1
