#Time Complexity : O(n+ log(m))
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        colums = len(matrix[0])
        for i in range(rows):
#Find the row in which the target may lie by comapiring it with row element in last column
            if target<= matrix[i][colums-1]:
#If target is less than the first column, return false, as it will not be present in the matrix
                if target>=matrix[i][0]:
#Binary search the row to get index of target
                    start = 0
                    end  = colums -1
                    while(start<=end):
                        mid = start + (end - start)//2
                        if matrix[i][mid] == target:
                            return True
                        if matrix[i][mid]>target:
                            end = mid-1
                        else:
                            start = mid+1
        return False