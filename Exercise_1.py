#Time Complexity : O(logN), N being number of values in matrix. 
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Fiddled with the searchArray portion 
#for a while. Also, mixed col and row in my head towards the end. 


#Your code here along with comments explaining your approach in three sentences only
'''Uses a binary search on first column to greatest value less than or equal target. 
Repeats with index of first column with row. '''

class Solution:
    def searchArray(self, array, target, low, high):
        #returns the index of the greatest value but less than or equal to target. 
        mid=int((low+high)/2)
        if target<array[low]:
            return -1
        elif target>=array[high]:
            return high
        elif high-low<=1:
            if target<array[high] and target>=array[low]:
                return low
        elif target<array[mid] and target>=array[low]:
            return self.searchArray(array, target, low, mid-1)
        elif target<array[high] and target>=array[mid]:
            return self.searchArray(array, target, mid, high)

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # obtain first column
        first_column = [c[0] for c in matrix]
        # obtain index of closest value in column
        index_col = self.searchArray(first_column, target, 0, len(first_column)-1)
        # obtain the row from index. 
        row = matrix[index_col]
        # obtain index of closest value of row. 
        index_row = self.searchArray(row, target, 0, len(row)-1)
        # see if value equals target. 
        value = matrix[index_col][index_row]
        return value == target