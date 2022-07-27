#time complexity - O(log(n))
#space complexity - O(1)
#solution ran on leetcode successfully
#no problems during coding


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        if(len(nums) == 0):
            return -1
        
        while(low <= high):
            mid = low + (high - low) // 2
            
            if(nums[mid] == target):
                return mid
            
            elif(nums[low] <= nums[mid]):
                if(nums[low] <= target and nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if(nums[mid] < target and nums[high] >= target):
                    low = mid + 1
                else:
                    high = mid-1
        
        return -1