'''
Time Complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        low = 0
        high = (row*col)-1
        while(low<=high):
            mid = int((low+high)/2)
            val = matrix[int(mid/col)][mid%col]
            if(val==target):
                return True
            if(val<target):
                low = mid+1
            if(val>target):
                high = mid-1
        return False