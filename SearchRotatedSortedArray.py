#Time Complexity: O(log n)
#Space Complexity: O(1)


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low<=high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid

            #right side sorted
            if nums[mid] <= nums[high]: 
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                
            #left side sorted
            else:
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                
        return -1