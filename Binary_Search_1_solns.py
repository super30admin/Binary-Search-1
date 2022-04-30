# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes I was dividing row by m not n

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n-1
        
        while low <= high:
            mid = (low + high) // 2
            row = mid // n
            col = mid % n
            
            if matrix[row][col] == target:
                return True
            elif target < matrix[row][col]:
                high = mid - 1
                
            else:
                low = mid + 1                
        
        return False


# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            
            if nums[low] <= nums[mid]:
                if target < nums[mid] and target >= nums[low]:
                    high = mid - 1
                    
                else:
                    low = mid + 1
                    
            elif nums[mid] <= nums[high]:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        return -1

# Time Complexity : O(logm + logn) ||  where m is the number of steps required for the target element to fall within range of the subarray. n is number of elements within the range
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope ... A bit confused about the time complexity

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        start = 0
        end = 1
        out_of_bound = 2**31 - 1
        while reader.get(end) < target:
            if reader.get(end) == out_of_bound:
                break
            start = end
            end <<= 1
               
        
        while start <= end:
            m = start + (end - start) // 2
            mid_ele = reader.get(m)
            if mid_ele == target:
                return m
            elif target < mid_ele:
                end = m - 1                
            else:
                start = m + 1                
        return -1