# Time Complexity : log n
# Space Complexity : n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major problems. Solved within 30 mins

# Your code here along with comments explaining your approach
# I treat it exactly as one long array except when I have to actually access the array I derive 2d index from
# 1d index using the length of arrays.

import math
class Solution:
    def searchMatrix(self, matrix, target):
        (total, each) = self.get_metrics(matrix)
        if total and each > 0:
            return self.bin_search(matrix, 0, total-1, target)
        return False
        
        
    def bin_search(self, nums, start, end, target):
        if start < end:
            mid = start + math.floor((end - start) / 2)
            mid_x, mid_y = self.get_2D_index_from_index(nums, mid)
            if nums[mid_x][mid_y] > target:
                return self.bin_search(nums, start, mid-1, target)
            elif nums[mid_x][mid_y] < target:
                return  self.bin_search(nums, mid+1, end, target)
            else:
                return True
        else:
            start_x, start_y = self.get_2D_index_from_index(nums, start)
            if nums[start_x][start_y] == target:
                return True
            return False
        
    def get_metrics(self, matrix):
        p = len(matrix)
        c = len(matrix[0]) if p > 0 else 0 
        total = p*c
        each = c
        return (total, each)
        
    def get_2D_index_from_index(self, matrix, n):
        (total, each) = self.get_metrics(matrix)
        x = n // each
        y = n % each
        return (x,y)

if __name__ == "__main__":
    s = Solution()
    nums = [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
    r = s.searchMatrix(nums, 2)
    print(r)
    r = s.searchMatrix(nums, 6)
    print(r)
    r = s.searchMatrix(nums, 4)
    print(r)
    r = s.searchMatrix(nums, 7)
    print(r)
    r = s.searchMatrix(nums, 10)
    print(r)
    r = s.searchMatrix(nums, 34)
    print(r)
