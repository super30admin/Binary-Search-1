# Time Complexity : O(logn)
# Space Complexity: O(1) as no additional space is used

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) <= 0:
            return False
        l = 0
        h = len(nums) - 1
        while(l <= h):
            mid = (l + h ) //2
            if target == nums[mid]:
                return mid
            
            # Check if left part is sorted, then search here
            if nums[l] <=  nums[mid]:
                if target >= nums[l] and target < nums[mid]:
                    h = mid -1
                else:
                    l = mid + 1
                
            # Else right part is sorted, then search here
            else:
                
                if target > nums[mid] and target <= nums[h]:
                    l = mid + 1
                else:
                    h = mid - 1
        return -1
        
