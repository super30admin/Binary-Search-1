"""
Check which side is sorted
Check if target is in the sorted side 
If not, go to the unsorted side, update pointers
Repeat
"""
class Solution(object):
    
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) is 0 or nums is None:
            return -1 
        
        low = 0
        high = len(nums) - 1     
        
        while low <= high:

            mid = low + (high - low)/2
            
            if nums[mid] == target:
                return mid
            
            # check which side is sorted
            if nums[low] <= nums[mid]:
                #left side is sorted
                # check if target is on sorted side
                if nums[low] <= target  and nums[mid] > target:
                    high = mid - 1
                # target on unsorted side
                else:
                    low = mid + 1
            elif nums[mid] <= nums[high]:
                #right side is sorted
                if nums[high] >= target and nums[mid] < target:
                    #target on sorted side
                    low = mid + 1
                else:
                    # target on unsorted side
                    high = mid - 1
        
        return -1

    
    
    
    
    
    