# Time Complexity : O(n)
# Space Complexity : O(1)
# Is this problem in Leetcode: Yes
# Approach to solve this problem: 

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1                # Initializing left and right value
        
        while l <= r:                          # when left is less than right, True
            mid = (l + r) // 2                 # Calculating mid value
            if target == nums[mid]:            # Edge case
                return mid
            
            # If in left sorted portion
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            
            # If in right sorted portion
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        
        return -1
        