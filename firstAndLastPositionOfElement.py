# // Time Complexity :O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        if target < nums[0] or target > nums[-1]:
            return [-1,-1]
        
        firstIndex = self.firstIndex(nums,target)
        if firstIndex == -1:
            return [-1,-1]
        
        secondIndex = self.secondIndex(nums,target)
        
        return [firstIndex, secondIndex]
    
    
    def firstIndex(self,nums,target):
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = low +(high-low)//2
            
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid -1 
                
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
                
        return -1
    
    def secondIndex(self,nums,target):
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = low +(high-low)//2
            
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                    return mid
                else:
                    low = mid+1
                
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
                
        return -1