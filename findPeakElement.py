# // Time Complexity : O(logN)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low = 0 
        high = len(nums) - 1 
        
        while low<= high:
            mid = low + (high-low)//2
            
            if (mid == len(nums)-1 or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid
            
            if mid !=0 and nums[mid-1] > nums[mid]:
                high = mid-1 
            else:
                low = mid+1
                
        return -1