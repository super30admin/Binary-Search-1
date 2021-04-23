class Solution :
    def searchMatrix(self,matrix,target):
        if len(matrix) == 0 :
            return -1

        m = len(matrix)
        n = len(matrix[0])
        low = 0 
        high = m * n  - 1

        while low <= high:
            mid = low + (high - low )/2
            r = int(mid / n) 
            c = int(mid % n)
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 13
obj = Solution()
print(obj.searchMatrix(matrix,target))