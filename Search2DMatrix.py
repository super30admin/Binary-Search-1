# Time Complexity : O(log2 m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def search2DMatrix(matrix, target):
    if not matrix:
        return False
    n = len(matrix)
    m = len(matrix[0])
    low = 0
    high = n*m-1
    while low <= high:
        mid = low+(high-low)//2
        row = mid//m
        col = mid%m
        if matrix[row][col] == target:
            return True
        elif matrix[row][col] < target:
            low = mid+1
        else:
            high = mid-1
    return False