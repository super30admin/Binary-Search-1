#Space complexity: O(n) where n is the number of elements
#time complexity: O(log n)
#was the problem accepted on leetcode: run code successfully, wrong while submission
#problem faced: not debugged yet
    
class Solution(object):
    def search(self, nums, target):
        low=0
        high = (len(nums) - 1)
        
        
        while (low <= high):
            mid = low + (high-low)/2
            
            if (nums[mid] == target):
                return mid
            
            elif (nums[low] < nums[mid]):
                if ((target >= nums[low]) and (target < nums[mid])):
                    high = mid-1
                else:
                    low = mid+1
            else:
                if ((target <= nums[high]) and (target > nums[mid])):
                    low = mid + 1
                else:
                    high = mid - 1 
        return -1
