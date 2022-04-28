'''
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Cant test or check in leet-code , just speculative solving
'''
class Solution:
    
    def binarySearch(self,arr,low,high,target):
        
        if low > high:
            return False
        
        # Find the mid
        mid = (high-low)//2 + low
        
        # Perform check
        if target == arr[mid]:
            return True
        
        elif target < arr[mid]:
            return self.binarySearch(arr,low,mid-1,target)
        
        else:
            return self.binarySearch(arr,mid+1,high,target) 
        
    def binarySearchDoubleUp(self,arr,low,high,target):
        
        if arr[high] < target:
            # Number in in-correct low-high range
            
            if high == 0:
                high = high + 1
            
            else:
                high = high * 2
                
            return self.binarySearchDoubleUp(arr,low,high,target)
        
        elif arr[high] > target:
            # We have found the correct range
            return (low,high)
        
        elif arr[high] == target:
            # We have found the index
            return (None,high)
        
    def resultFunc(self,nums,target):
        rtrResult =  self.binarySearchDoubleUp(nums, 0, 0, target)
        
        if rtrResult[0] == None:
            # We have found the target
            return rtrResult[1]
        
        else:
            # Perform binarySearch
            return self.binarySearch(nums, rtrResult[0], rtrResult[1], target)

sol = Solution()
sol.resultFunc([-1,0,3,5,9,12], 12)