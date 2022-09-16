"""
 FAANMG Problem #6 {Easy}

Problem 2
33. Search in Rotated Sorted Array

Time Complexity : O(N+logN)
 
Space Complexity : O(N)

    
Iterating the array to check if the array is oated and storing the index K for the array to be rotated
Then Applying Binary search on the array


Any problem you faced while coding this:
    The case for two value array was not satisfied.
    It was fixed with adding the edge case
     if((idx)== (size-1)):
                break
    
@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    
    def binarySearch(self, arr, target, l , r):
        
      
        while(l<=r):
            mid=(l+r)//2
            
            if(arr[mid]==target):
                return mid
            
            if(target <= arr[mid] ):
                r = mid-1
                
            else:
                l = mid+1
               
        return -1
    
    
    def search(self, nums: List[int], target: int) -> int:
        
        rotated=False
        k=0
        size= len(nums)
        
        for idx,val in enumerate (nums):
            
            #Edge case if its the last element
            if((idx)== (size-1)):
                break
            #Check if the current value is greater than the next value
            #If yes then it means the array is roated as the condition states in ascending order
            if(val > nums[idx+1]):
                k=idx+1
                rotated=True
        
        #If the array is rotated, then send the temp array with current oreder split by k
        if(rotated):
            temp= nums[k:]+nums[:k]
            
            idx = self.binarySearch( temp , target, 0 , size-1)
            
            if idx==-1:
                return -1
            else:
                return (idx+k) % size
            
        else:
            return self.binarySearch(nums , target, 0 , size-1)