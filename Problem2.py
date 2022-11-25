#Time complexity:
# O(log(n)) where n is the total number of elements in the array

#Space complexity:
# O(1) - no extra space used

#Approach: Execute binary search, at each step check if left side sorted or right side sorted
# If element lies in the sorted side, change bounds to match sorted side
# Else element lies on the unsorted side, so change bounds to match unsorted side

class Solution:
            
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        
        if len(nums) == 0:
            return -1
        
        low = 0
        high = n - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            
            #if left side sorted
            
            if nums[low] <= nums[mid]:
                if nums[low] <= target and target < nums[mid]: #target must lie on left side i.e sorted side
                    high = mid - 1
                else: #target must lie on right side i.e unsorted side
                    low = mid + 1
                
            #if right side sorted
            else:
                if nums[mid] < target and target <= nums[high]: #target must lie on the right side i.e sorted side
                    low = mid + 1
                else: #target must lie on left side i.e unsorted side
                    high = mid - 1
        
        return -1 
                    
                    
        
        
        
        
        