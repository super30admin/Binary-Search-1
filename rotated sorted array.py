# time complexity to search the target is o(log(n))
# space complexity o(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            mid = low + (high - low) // 2
            if(nums[mid] == target):
                return mid
            elif(nums[low] <= nums[mid]):#left side of mid is sorted
                if(nums[low] <= target and target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            else:#right side of mid is sorted
                if(nums[mid] < target and target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
    
   
