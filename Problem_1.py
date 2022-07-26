"""
 Time Complexity : O(mn), where m is number of column and n is number of rows
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


 Your code here along with comments explaining your approach

 Problem 1 : Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
             Integers in each row are sorted from left to right.The first integer of each row is greater than the last integer of the previous row.

"""
class Solution:
    def find_row(self, matrix, target, low, high):
       """
       Helper function to find the correct row in which target could be present
       Itype : int
       rtype: int
       """
       if len(matrix)==0 or len(matrix[0]) == 0:
            return -1

       while low <= high:
            mid = (low + high) // 2
            if target >= matrix[mid][0] and target <= matrix[m][len(matrix[m]) - 1]:
                return mid
            elif (matrix[m][0]> target):
                high = mid -1
            else:
                low = mid +1

       return -1


    def find_col(self, arr, target, low, high):
        """
        Helper function to find the col of the target
        itype: int
        rtype: int
        """
        if len(arr)==0:
            return -1

        while low <= high:
            mid = (low + high)//2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid -1
            else:
                low = mid +1
        return -1    

    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        In this approach, we are using binary search(BS) on rows and cols,
        First we will find the correct row using BS and then the index using BS
        Itype : List[List[int]], target
        rtyep: bool
        """
        if len(matrix)==0 or len(matrix[0]) == 0:
            return False

        m = len(matrix[0])-1 #number of col
        n = len(matrix)-1     #number of rows

        row = self.find_row(matrix, target, 0, n )

        if row == -1:
            return False
        
        col = self.find_col(matrix[row], target,0 , m)

        if col != -1:
            return True

        return False

        
class Solution_1:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        In this approach, we are considering an array of size of matrix elements
        and applying Binary search on it.
        Itype: int
        rtyep: bool
        """
        if len(matrix)==0 or len(matrix[0]) == 0:
            return False

        m = len(matrix[0]) #number of col
        n = len(matrix)     #number of rows
        low, high  = 0 , (m * n -1)

        while low <= high:
            mid = (low + high)//2
            #Dividing by m as col size decides the no of rows
            row = mid//m
            col = mid%m
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid -1
            else:
                low = mid +1

        return -1


        



        
        