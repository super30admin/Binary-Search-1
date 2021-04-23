"""
Intuition: If the array is rotated, one of the half's is ALWAYS sorted.
We focus on that sorted part if possible. 
We then check if the number should be in that sub-sorted array.

#####################################################################
Time Complexity : O(log n) where n = number of elements
Space Complexity : O(1)
#####################################################################

"""

[class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums) -1
        
        while low <= high:
            
            mid = (low+ high)//2
            
            if nums[mid] == target:
                return mid
            
            #Checking if sorted.
            if nums[low] <=nums[mid]:

                #Checking if the number is present within that range.
                if nums[low]  <= target < nums[mid]:
                    high = mid -1
                else:
                    low = mid +1
                
            else:
                if nums[mid]  < target <= nums[high]:
                    low = mid +1
                else:
                    high = mid -1
                                
        return -1]