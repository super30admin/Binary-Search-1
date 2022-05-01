# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums, target):
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + right - left // 2

            # Target found
            if target == nums[mid]:
                return mid
            
            # Left part of the array is sorted
            elif nums[left] <= nums[mid] :
                # Target belongs to
                if target < nums[mid] and target >= nums[left]:
                    right = mid - 1
                else:
                    left = mid + 1
            
            # Right part of the array is sorted
            else:
                if target > nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
         
        return -1

solution = Solution()
print(f"OUTPUT >> {solution.search([4,5,6,7,0,1,2,3], 2)}")