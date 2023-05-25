# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#The code will check the last element of every row and then check for target in every row. The Time Complexity is thus O(m*n) in worst case
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows , cols = len(matrix) , len(matrix[0])
        print("Rows:",rows ,"columns:",cols)
        rows -=1
        cols -=1
        row =0
        while row<=rows and cols>=0:
            if matrix[row][cols]==target:
                return True
            elif target<matrix[row][cols]:
                cols -=1
            else:
                row+=1
        return False
