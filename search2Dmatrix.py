

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # Base case:  check if the matrix exists or its a null matrix
        if not matrix or not matrix[0]:
            return False
        
        '''
        for x in range(len(matrix)):
            
            if target == matrix[x][0] or target == matrix[x][-1]:
                return True
            
            elif target > matrix[x][0] and target < matrix[x][-1]:
                # look for element in row
                l, r = 0, len(matrix[x]) - 1
                
                while l <= r:
                    # to prevent overflow
                    mid = l + (r - l) // 2
                    
                    if target == matrix[x][mid]:
                        return True
                    
                    elif target > matrix[x][mid]:
                        l = mid + 1
                        
                    else:
                        r = mid - 1
                        
                return False
            '''
        
        
        # flatten the matrix. total number of elements = MxN
        lo, hi = 0, len(matrix) * len(matrix[0]) - 1
        
        while lo <= hi:
            mid = (lo + hi) // 2
            # get the row
            r = mid // len(matrix[0])
            # get the column
            c = mid % len(matrix[0])
            if matrix[r][c] == target: return True
            if target > matrix[r][c]: lo = mid + 1
            else: hi = mid - 1
        return False

                
                