# Time Complexity : O(log (raw * col)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


def searchMatrix(matrix,target):
    if matrix == None or matrix.length == 0:
        return False
    r = len(matrix)
    c = len(matrix[0])
    low = 0
    high = r*c -1
    while (low < high):
        mid = low + (high-low)//2
        mRaw = mid // c
        mCol = mid % c
        if matrix[mRaw][mCol] == target:
            return True
        elif matrix[mRaw][mCol] > target:
            high = mid - 1
        else:
            low = mid + 1 
    return False