class Solution(object):
    def search(self, nums, target):
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2
            
            if target == nums[mid]:
                return mid
            # if first part sorted and item if there or not 
            if nums[low] <= nums[mid]:
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            # if 1st part not sorted part and item present or not
            else:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        return -1
 

        """
        ideal input [4 5 6 7 8 9 0 1 2]
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        