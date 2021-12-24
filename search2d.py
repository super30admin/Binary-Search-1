
"""
Use binary search algo
refer to middle, compare to target
"""


class Solution:
    def __init__(self):
        print("in init")

    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:


        #perform 2 binary search, runtime is O(log(mn)
        if len(matrix[0]) == 0 or len(matrix) == 0:
            return False

        low = 0; high = len(matrix)
        #binary search column
        while low < high:
            middle = low + high // 2
            if matrix[middle][0] < target:
                low = middle + 1
            elif matrix[middle][0] > target:
                high = middle - 1
            else:
                return True

        #binary search the row
        row = high
        high = len(matrix[row]) - 1
        if row >= 0:
            while low <= high:
                middle = (low + high) // 2;
                if (matrix[row][middle] < target):
                    low = middle + 1;
                    
                elif (matrix[row][middle] > target): 
                    high = middle - 1;
                else:
                    return True;
        return False;
matrix1 = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]

print(len(matrix1))
obj1 = Solution()
print(obj1.searchMatrix(matrix1,3))
   