# APPROACH - 1 (Finding pivot and then do Binary Search)
# Time Complexity : O(lg n) - find_pivot, binarySearch
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Updating start and end in find_pivot


# Your code here along with comments explaining your approach
# 1. Firstly, find pivot with modified Binary Search (find_pivot function). Pivot is less than the previous element. You won't do this if the array is fully sorted and not rotated by checking first and 
# last element
# 2. This pivot divided the whole array into two sorted parts. Compare target with start/end variable to decided which part it lies in.
# 3. Do Normal Binary Search in the selected half (binarySearch function)



class Solution:
    def find_pivot(self, nums):
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] > nums[mid + 1]:
                return mid + 1
            elif nums[start] < nums[mid]:
                start = mid 
            elif nums[start] > nums[mid]:
                end = mid
                
    
    def binarySearch(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1
        return -1
            
        
    def search(self, nums: List[int], target: int) -> int:
        
        if not nums:
            return -1
        
        if nums[0] > nums[-1]:
            pivot = self.find_pivot(nums)
            
            if nums[pivot] == target:
                return pivot
            
            elif nums[0] <= target:
                result = self.binarySearch(nums, 0, pivot - 1, target)
            
            elif nums[0] > target:
                result = self.binarySearch(nums, pivot, len(nums) - 1, target)
                
        else:
            result = self.binarySearch(nums, 0, len(nums) - 1, target)
            
        return result
        
        
        
#  APPROACH - 2 (Single Binary Search - Iterative)
# Time Complexity : O(lg n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : To check which array half is sorted 


# Your code here along with comments explaining your approach
# 1. In each iteration, either left or right half will be sorted. Compute mid and check if it equals target
# 2. Else, check if right half is sorted - then check if target falls in this half or not. Update start, end accordingly.
# 3. If right half is not sorted, check if left half is sorted - then check if target falls in left half or not, update start, end appropriately.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            
            if nums[mid] == target:
                return mid
            
            elif nums[mid] <= nums[end]:
                if nums[mid] < target and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
                    
            else:
                if nums[start] <= target and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
                    
        return -1
        


# APPROACH - 3 (Single Binary Search - Recusrsive)
# Time Complexity : O(lg n)
# Space Complexity : O(1) - not considering the space taken up by recursive call stack - WRONG
#                    O(lg n) - MUST consider recursive stack calls in SC. Here, there are O(lg n ) calls to recursiveBinarySearch(). 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
# Its the same approach as above. Only difference is it's implemented recursively.

class Solution:
    def recursiveBinarySearch(self, nums, start, end, target):
        if start > end:
            return -1
        mid = start + (end - start) // 2
        if nums[mid] == target:
            return mid
        
        elif nums[start] <= nums[mid]:
            if nums[start] <= target and target < nums[mid]:
                return self.recursiveBinarySearch(nums, start, mid - 1, target)
            else:
                return self.recursiveBinarySearch(nums, mid + 1, end, target)
        
        else:
            if nums[mid] < target and target <= nums[end]:
                return self.recursiveBinarySearch(nums, mid + 1, end, target)
            else:
                return self.recursiveBinarySearch(nums, start, mid - 1, target)
            
            
    def search(self, nums: List[int], target: int) -> int:
        return self.recursiveBinarySearch(nums, 0, len(nums) - 1, target)
        
