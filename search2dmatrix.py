#Executed on leet code
#Time complexity-O(logmn)
#Space complexity - O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #If target is none and not , matrix false is returned 
        if not matrix or target is None:
            return False
        rows,cols = len(matrix),len(matrix[0])
        low,high = 0,rows*cols-1
        #now apply bst 
        while low <= high:
            mid = (low + high) // 2
            nums = matrix[mid // cols][mid % cols]
            if nums==target:
                return True
            elif nums<target:
                low = mid+1
            else:
                high = mid-1
        return False
                   
    