# Time Complexity : log(MN). Consider 2d matrix as 1d array for search, total elements in array is MxN, where M is number of rows and N is number of columns
# Space Complexity : O(1) no extra memory allocated, only constant variables are used
# 74. Search a 2D Matrix

def searchMatrix(matrix, target: int) -> bool:
    #Consider 2d array as a 1d for indexing
    nRows,nCols = len(matrix), len(matrix[0])
    low, high = 0, nRows*nCols - 1 
    while low <= high:
        mid = low + (high - low)//2
        #Convert to 2d index
        r = mid//nCols
        c = mid%nCols

        if matrix[r][c] == target:
            return True
        elif target > matrix[r][c]:
            low = mid + 1
        else:
            high = mid - 1
    return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
print(searchMatrix(matrix, target))
target = 2
print(searchMatrix(matrix, target))




