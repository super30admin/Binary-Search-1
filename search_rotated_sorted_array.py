class Solution:
    def search(self, nums, target):
        low = 0
        high = len(nums) - 1
        '''
        1.Find the sorted array at every low-> mid and mid-> high
        2. If array is sorted from low-> mid:   
            1. Check if target < array[mid] and target > array[low]
        3. Else:
            1. Check if mid-> high are sorted:
                1. Check if target > array[mid] and target < array[high]
        4. If element is not found in any of the range:
            Follow normal binary search
        '''
      
        
        while(low <= high):
            mid = (low + high)//2
 
            if target == nums[mid]:
                    return mid
            
            # Check if left side is sorted
            elif nums[low] <= nums[mid]:
                # Array is sorted low --> mid
                # Check if target lies in range low --> mid
                
                if target >= nums[low] and target < nums[mid]:
               
                    high = mid - 1
                else:
                    low = mid + 1
               
            else:
               
                if (target > nums[mid] and target <= nums[high]):
                  
                    low = mid + 1
                else:
                    high = mid - 1

                    
                    
                    
        return -1   
                    
            
        
       
            
            
        