# Time Complexity : O(nlog(n))
# Space Complexity : 0(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
       
            def bin_search(arr: List[int], num: int) -> int:
                l, r = 0, len(arr) - 1
                while l + 1 < r:
                    mid = (l + r) // 2
                    if arr[mid] > num:
                        r = mid
                    else:
                        l = mid
                return l, r
            
            row1, row2 = bin_search([matrix[i][0] for i in range(len(matrix))], target)
            col1, col2 = bin_search(matrix[row1], target)
            print(matrix[row1][col1])
            print(matrix[row2][col2])
            if matrix[row1][col1] == target or matrix[row1][col2] == target:
                return True
            col1, col2 = bin_search(matrix[row2], target)
            return matrix[row2][col1] == target or matrix[row2][col2] == target