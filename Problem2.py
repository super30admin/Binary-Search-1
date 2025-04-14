# Leetcode 33: Search in Rotated Sorted Array

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        start = 0
        end = len(nums)-1
        
        while(start <= end):
            
            mid = (start + end)//2
            
            if nums[mid] == target:
                return mid
            
            if nums[mid] >= nums[start]:
                
                if target >= nums[start] and target < nums[mid]:
                    
                    end = mid-1
                else:
                    
                    start = mid + 1
            else:
                
                if target > nums[mid] and target <= nums[end]:
                    
                    start = mid+1
                else:
                    end = mid-1
        
        return -1