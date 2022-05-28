'''// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
class Solution(object):
      
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # Check if the list is empty
        if len(nums) == 0:
            return -1
        
        #Initialize low at the 0 index and high as the last index
        low = 0
        high = len(nums)-1
        
        while( low <= high ):
            
            mid = low + (high-low)/2
            
            if nums[mid] == target:
                return mid

            #Check if the left hand side is sorted
            elif nums[low] <= nums[mid]:
                #Check if the target is in range of left hand side 
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1 
                else:
                    low= mid + 1
            #Right side is sorted
            else: 
                #Check if the target is in range of right hand side 
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
        
        
        
