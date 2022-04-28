class Solution:
    
    def binarySearch(self,nums,low,high,target):
        if low>high:
            return -1
        
        # Return the result 
        
        # Get mid index
        mid = (high-low)//2 + low
        
        if nums[mid] == target:
            return mid
        
        elif mid-1 >= 0 and nums[low]<=target<=nums[mid-1]:
            rtrResult = self.binarySearch(nums,low,mid-1,target)
            
            if rtrResult == -1:
                rtrResult = self.binarySearch(nums,mid+1,high,target)
            
            return rtrResult
            
        elif mid+1 <= len(nums)-1 and nums[mid+1]<=target<=nums[high]:
            return self.binarySearch(nums,mid+1,high,target)
        
        else:
            # Now we need to individual check the lhs of list first; then rhs (conditionally)
        
            #  Check the lhs of the list
            rtrResult = self.binarySearch(nums,low,mid-1,target)
            
            if rtrResult == -1:
                # Check th rhs of the list
                rtrResult = self.binarySearch(nums,mid+1,high,target)
            
            return rtrResult
        
    def search(self, nums, target: int) -> int:
         return self.binarySearch(nums,0,len(nums)-1,target)