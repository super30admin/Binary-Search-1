# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1
        
        # return -1 if array is empty
        if h == -1:
            return h
        # If array is not rotated then set pivot at index 0
        if nums[0] <= nums[-1]:
            m = 0
        
        #Else find the pivot
        else:
            while l <= h:
                m = l + (h-l)//2
                
                # Contition for a pivot
                if nums[m] > nums[m+1]:
                    m = m+1
                    break
                # If left sub array is an increasing sequence then ignore it
                elif nums[l] <= nums[m]:
                    l = m+1
                # If right sub array is an increasing sequence then ignore it
                else:
                    h = m-1
        # If pivot is the target then return index
        if target == nums[m]:
            return m
        # If target is in left subarray then set low and high pointers to left subarray
        elif target <= nums[-1]:
            l = m+1
            h = len(nums)-1
        # If target is in left subarray then set low and high pointers to left subarray
        else:
            l = 0
            h = m-1
        
        # Apply binary search in the sub array 
        while l <= h:
            m = l + (h-l)//2
            
            if nums[m] == target:
                return m
            elif nums[m] < target:
                l = m+1
            else:
                h = m-1 
          
        return -1