
# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        m = len(matrix)
        n = len(matrix[0])
        lo = 0
        hi = (m*n) - 1

        while lo <= hi:
            mid = lo + ( hi - lo)//2
            elem = matrix [ mid // n] [ mid % n]

            if elem == target:
                return True  
            elif elem < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#Your code here along with comments explaining your approach in three sentences only

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        l = 0 
        r = len(nums) - 1 
        while l <= r:
            mid = l + (r-l)//2

            if nums[mid] == target:
                return mid 
            if nums[l] <= nums[mid]:

                if target > nums[mid] or target < nums[l]:
                    l = mid+1
                else:
                   r = mid -1
            else:
                if target > nums[r] or target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
        return - 1

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
#Your code here along with comments explaining your approach in three sentences only start with low as 0 and high as 1. keep increasing high by a factor of twpo until you get a value that is higher or equal to element 
#meanwhile keep updating low to high. once you get range then perform binary serach on it 

class Solution:
    def binarysearch(self,lo,hi,reader,target):
        while lo <= hi:
            mid = lo + (hi-lo)//2
            elem = reader.get(mid)
            if elem == target:
                return mid
            elif elem < target:
                lo = mid+1
            else:
                hi = mid -1 
        return -1
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0 
        hi = 1
        while(reader.get(hi) <= target):
            low = hi
            hi = 2 * hi
        return self.binarysearch(low,hi,reader,target)