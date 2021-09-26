#Time Complexity : O(logn)
#Space Complexity : o(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        
        while(low<=high):
            mid = int(low+ (high-low)/2)
            if nums[mid] == target:
                return mid
            elif nums[low]<=nums [mid]: # checking to see if left part of the arr is sorted 
                if (target >= nums[low] and target<= nums[mid]): #checking to see if target is within the range
                    high = mid-1
                    
                else:
                    low = mid+1
            else: # right partt of the array is sorted 
                if (target<= nums[high] and target>=nums[mid]):
                    low = mid+1
                else:
                    high = mid-1
        
        return -1
            
