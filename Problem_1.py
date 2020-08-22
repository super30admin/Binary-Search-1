# Approach: Since the question says sorted array we can use Binary search logic!

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low + (high-low) //2
            
            if nums[mid]==target:
                return mid
            elif nums[mid]>=nums[low]:
                if target>=nums[low] and target<=nums[mid]:
                    high=mid-1
                else:
                    low = mid+1
            else:
                if target>=nums[mid] and target<=nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1
    
# Time complexity: O(logN)
# Space complexity: O(1)
                