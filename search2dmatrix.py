'''
Time comlexity of this algo will be (log(m) + log(n)) = big-oh(log(max(m,n)))
Space complexity O(1)
'''

class Solution:
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # boundry case
        n =  len(matrix) 
        if n == 0: return False
        m = len(matrix[0])
        if m == 0 : return False
        
        # binary search in first index of row  // verticale binary search
        low =  0                                            
        high = n                                # catch "till n" not "n -1" to include the last row
        while low < high -1:                    # terminating condition
            mid = low  + (high-low)//2
            if matrix[mid][0] == target: 
                return True
            if target < matrix[mid][0]:
                high = mid
            else:
                low = mid
        
        # binary search in a row // horizontal binary search // simple bs
        row = low
        low = 0
        high = m-1
        while low<=high:
            mid  = low  + (high- low)//2
            if matrix[row][mid] == target:
                return True
            if target < matrix[row][mid]:
                high = mid -1
            else:
                low = mid  +1
        return False