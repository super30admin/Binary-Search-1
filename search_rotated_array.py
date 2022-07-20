# Time complexity : O(log n)
# Space complexity : O(1)
# Leetcode : Solved and submitted
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        
        low = 0
        high = n - 1
        
        # starting the while loop going from low till high
        while low <= high:
          
            # calculate middle element also called the pivot element
            mid = low + (high - low) // 2
            
             # checking if the middle element is the target element, if yes, then return the index
            if target == nums[mid]:
                return mid
              
            # checking if the target element lies within the left sub-array by checking the value of target with the 
            # middle element and the starting element, if yes, then keep searching here, else search in the right subarray
            elif nums[mid] >= nums[low]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            
            
            # checking if the target element lies within the right sub-array by checking the value of target with the 
            # middle element and the last element, if yes, then keep searching here, else search in the left subarray
            else:
                if target <= nums[high] and target > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1       
