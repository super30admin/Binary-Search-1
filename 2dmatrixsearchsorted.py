#Time Complexity : O(log m + log n) = o(log mn)
#Space Complexity : O(1) as we are using low,high,mid,r,c.
#Did you code executed on leetcode : yes it did
#Issues encounter: how to convert 2d matrix to 1d array and how to find value of r and c

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n -1

        while (low <= high):
            mid = low + (high - low)//2
            #to find position of mid in 2d array
            r = mid // n
            c = mid % n
            
 
            if (matrix[r][c] == target):
                return True
            elif (matrix[r][c] > target):
                high = mid - 1
            else:
                low = mid + 1
        return False
