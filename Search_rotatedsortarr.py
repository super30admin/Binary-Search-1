# Time Complexity: O(log n)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1
        
        while l <= h:
        
            m = l + (h-l) // 2
            
            if target == nums[m]:
                return m
            # check if left sub-arr is sorted
            elif nums[l] <= nums[m]:
                # check if the target is in range(l, m)
                if target >= nums[l] and target < nums[m]:
                    h = m - 1
                else:
                    l = m + 1
            # check if right sub-arr is sorted
            else:
                # check if the target is in range(m, h)
                if target <= nums[h] and target > nums[m]:
                    l = m + 1
                else:
                    h = m - 1
        # if the element is not present then return -1
        return -1
                    
                