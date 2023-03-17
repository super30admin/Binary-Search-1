class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix== None and len(matrix)==0:
            return False

        # n-> Rows
        n= len(matrix) #3
        #m-> Columns
        m= len(matrix[0])# 4
        low= 0
        high= m * n - 1
        
        while low<=high:
            # Assume it as a 1D array and compute the mid.
            mid= low +(high-low)//2 # 5 
            row= mid//m #5//4 ->1
            column= mid % m # 5%4 ->1
            if target== matrix[row][column]:
                return True
            elif target < matrix[row][column]:
                high= mid-1
            else:
                low= mid+1
        return False

arr= [[1,3]]
obj= Solution()
obj.searchMatrix(arr, 3)
