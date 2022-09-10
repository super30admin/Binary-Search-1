#Time-Complexity: O(logn)
#Space-Complexity: O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo = 0 
        hi = len(nums) - 1
        
        while lo <= hi:
            mid = (lo+hi)//2
            
            #You got the element 
            if nums[mid] == target:
                return mid
            
            #If you look closely you will notice that after rotation when u find the mid
            #one part of the array will be sorted always. Either the left part or the
            #right part. 
            
            #Check if the left part is sorted.
            if nums[lo] <= nums[mid]:
                #If it is then check if your element lies in the left sorted array.
                if  target >=nums[lo] and target < nums[mid]:
                    #if yes go to left
                    hi = mid - 1
                else:
                    #if no go to right
                    lo = mid + 1  
            #If left part is not sorted then right must be sorted.         
            else:
                #Check if your element lies in the right sorted array.
                if target> nums[mid] and target <= nums[hi]:
                    #if yes go to right
                    lo = mid + 1
                else:
                    #if no go to left
                    hi = mid - 1
                    
        #if element not found return -1     
        return -1