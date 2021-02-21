'''
// Time Complexity : TC overall due to binary search: log n

// Space Complexity : O(1) as there is no duplication of data

// Did this code successfully run on Leetcode :
   yes
// Any problem you faced while coding this :
   I made mistakes when comparing the nums[] at low and mid logic was clear but in the code I made a mistake. 
   
Note: I would like some feedback about the programs submitted until now.
// Your code here along with comments explaining your approach

'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        low = 0 # the first index of the array
        high = n-1 # the last index of the array
        
        while low <= high:
            mid = int(low + (high-low)/2) # mean / average value of low and high  
            
            # we first teck if the target value is at mid position if true then return the index.
            if nums[mid]==target:
                return mid
            # we check the section of the array from low to mid and check if it's sorted
            elif nums[low]<=nums[mid]:
            
                    # here we check if the target value lies in the range of the low and mid if yes the assign the variable high -> mid - 1 to eliminate the other section
                    if nums[low]<=target and nums[mid]>target:
                        high = mid - 1
                        
                    # if not then assign low -> mid +1 to eliminate the current section 
                    else:
                        low = mid + 1
            else:
                 # this works similarly like the above elif statments but here we search for the target first in range between mid and high
                if nums[mid] < target and nums[high]>=target:
                    low = mid + 1
                else:
                    high = mid - 1
        # if elemient not found return -1       
        return -1
