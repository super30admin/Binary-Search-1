# // Time Complexity : O(log n)
# // Space Complexity : O(1) in-place
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach


# We will use the last element to divide the array into two zones, let's call it the polestar
# green - Rotated sorted half
# orange - Original sorted half
# EG [4,5,6,7,0,1,2] - Here, 4,5,6,7 are green (Greater than polestar) and 
# 0,1,2 are orange(Less than polestar)
# Once we know what region the polestar lies in, we will perform a binary search for the target based on what region mid lies in and what region the target lies in...more comments in-line
        
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0: return -1
        polestar = nums[-1]
        start = 0
        end = len(nums) - 1
        if target == polestar:
                return len(nums) - 1
            
        # Determine which region the target is in
        if target < polestar:
            region = 'orange'
        else:
            region = 'green'        
        
        while start <= end:
            # Let's do a binary search for the target
            mid = start + (end - start) // 2
            if target == nums[mid]:
                return mid
            
            if nums[mid] < polestar: # mid lies in orange region
                if target < nums[mid] or region == 'green': # If target is in green region or target < mid, decrement end, move left
                    end = mid - 1
                else: # Target is greater than mid, move right
                    start = mid + 1
            else: # mid is in green region
                if target > nums[mid] or region == 'orange': # If target is in orange region or target is > mid, move right
                    start = mid + 1
                else: # target less than mid, move left
                    end = mid - 1
        return -1