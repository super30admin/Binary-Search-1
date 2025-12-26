# Problem 1: Problem1 Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# Time Complexity : O(log n)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        ## we want to treat the 2d matrix as 1d matrix
        ## so get the cols and rows 
        ## important concept here is how we get the row and col for value retrival from matrix
        ## for row we divide by cols
        ## for col we mod by cols
        ## once we have that we can just do the binary search
        rows = len(matrix)
        cols = len(matrix[0])
        
        l=0
        r = rows*cols-1

        while l<=r:
            mid = l+(r-l)/2
            row = mid/cols
            col = mid%cols
            
            if matrix[row][col] == target:
                return True
            
            if matrix[row][col]< target:
                l= mid+1
            else:
                r=mid-1

        return False


# Problem2 Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l, r = 0, len(nums) - 1
        ## initialize the l and r 
        ## start performing the binary search, but we can directly do binary search here
        ## because the array is not sorted, so we first need to find out sorted array
        ## check if left side is sorted, if yes then check target is in left or right portion and adjust the l,r index
        ## if left is not sorted then surely right will be sorted, check in the right
        ## again check if left or right portion and adjust the indexes
        while l <= r:
            mid = (l + r) // 2

            if nums[mid] == target:
                return mid

            # Left side is sorted
            if nums[l] <= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            # Right side is sorted
            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

        return -1

# Problem3 Search in Infinite sorted array:https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l=0
        r=1
        ## here we need to do binary search twice. Once to find out the range, we start small and gradually double the 
        ## search space to find the range where the target actually lie. 
        ## once we have the left and right bounds, we can perform the binary search and return index if found
        while reader.get(r) < target:
            r = 2*r
            
        while l<=r:
            mid = l + (r-l)/2
            val = reader.get(mid)
            if val == target:
                return mid
            if val < target:
                l = mid +1
            else:
                r = mid-1
        return -1
