# Binary search in a rotated array
# Version 1
# Time Complexity O(logn)
# Space complexity O(1)
# It passed all the test cases in leetcode
# Any problems faced? Nothing major

def binary_search(arr, tar):
    i = 0
    j = len(arr) - 1

    while i <= j:
        k = (i+j) // 2
        if arr[k] == tar:
            return True
        elif tar < arr[k]:
            j = k-1
        else:
            i = k+1

    return False

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # this is a modified binary search, find the row it belongs too
        
        m = len(matrix) 
        n = len(matrix[0])
        i = 0
        j = m - 1
        
        while i <= j :
            k = (i+j)//2
            if matrix[k][0] == target:
                return True
            elif target < matrix[k][0]:
                j = k - 1
            else:
                i = k + 1
        
        row_to_be_searched = j
        if j == -1:
            return False
        if j == k:
            row_to_be_searched = j
            if j == m -1 and target > matrix[j][n-1]: # this is an optimization step
                return False
        elif target > matrix[j][n-1] and target < matrix[k][0]: # this is an optimization step
            return False
        elif target == matrix[j][n-1]: # this is an optimization step
            return True
        
        return binary_search(matrix[row_to_be_searched], target)
        
    
        
