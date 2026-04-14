class Solution:
    def searchMatrix(self, matrix, target):
        rows,cols = len(matrix),len(matrix[0])
        n = rows * cols
        low,high = 0,n-1
        while low <= high:
            mid = low + (high-low)//2
            curr = matrix[mid//cols][mid%cols]
            if target == curr:
                return True
            if target < curr:
                high = mid -1 
            else:
                low = mid + 1
        return False

sol = Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
print(sol.searchMatrix(matrix,target))
print(sol.searchMatrix(matrix,99))