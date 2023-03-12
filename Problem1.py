import itertools
import math
#Time complexity : Total number of elements in the list = m*n and binary search is applied on them. So O(m*n)
#Space complexity : nums list requires space,so O(m*n)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        nums = list(itertools.chain.from_iterable(matrix))
        return Solution.binarySearch(0,len(nums)-1,nums,target)
    def binarySearch(l:int,r:int,nums : List[int],target:int):

        if(l<=r and l>=0 and r<len(nums)):
            mid = math.floor((l+r)/2)
            if(nums[mid] == target):
                return True
            elif(target<nums[mid]):
                r = mid-1
                
                return Solution.binarySearch(l,r,nums,target)
            else:
                l = mid+1
                return Solution.binarySearch(l,r,nums,target)
        return False

    




