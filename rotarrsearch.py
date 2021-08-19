# Time Complexity : O(logn) as it is binary search with n = len(nums) elements
# Space Complexity : O(1) as no extra space used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, took me a little time to understand 
# the limits of the interval in the binary search

class RotatedArraySearch:

    def rotarrsearch(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target == nums[mid]:
                return mid
            elif nums[mid] >= nums[left]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target <= nums[right] and target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
                    


                
                    