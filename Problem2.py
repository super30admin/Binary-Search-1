class Solution:
    def search(self,nums,target):
        if len(nums) == 0:
            return -1
        
        low = 0 
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low)/2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if target > nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            
            elif nums[mid] <= nums[high]:
                if target > nums[mid] and target < nums[high]:
                    low = mid +1 
                else:
                    high = mid - 1
            return -1

