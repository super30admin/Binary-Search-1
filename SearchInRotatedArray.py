class Solution:
    def search(self, nums, target: int) -> int:
        if not nums:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while (low<=high):
            mid = low + (high - low)//2
            
            if (nums[mid] == target):
                return mid
            
            # check if left sorted
            if (nums[low]<=nums[mid]):
                # check if target is on sorted side
                if (nums[low]<= target and nums[mid]>target):
                    high = mid -1 
                else:
                    low = mid + 1 
            
            # check if right side is sorted
            elif (nums[mid] <= nums[high]):
                if (nums[mid]<target and nums[high]>=target):
                    low = mid + 1
                else:
                    high = mid -1 
                    
        return -1
    
    # TC: O(log n)
    # SC: O(1)
