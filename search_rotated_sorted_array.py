"""Python implementation of a search in a rotated array
Time complexity : O(logN) where N is the number of elements in the array
Space Complexity : O(1) re-using the given array 
Did the program run for all test cases on leetcode ? : Yes
"""


class Solution:
    def search(self, nums: [int], target: int) -> int:
        l =0
        r = len(nums) - 1
        
        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid
            # nums[left to mid] is sorted 
            if nums[l] <= nums[mid]:
                if (target < nums[mid]) and (target > nums[l]):
                    r = mid - 1
                else:
                    l = mid + 1                    
            # nums[mid to right] is sorted
            else:
                if (target > nums[mid]) and (target < nums[r]):
                    l = mid + 1
                else:
                    r = mid - 1                  
        return -1
    
#Driver code
s = Solution()
nums = [4,5,6,7,0,1,2]
target = 0
print(s.search(nums,target))
    