class Solution(object):
    def searchMatrix(self, matrix, target):
        m =len(matrix)  
        n =len(matrix[0])
        l=0
        r= m*n-1

        while l<=r:
            mid_index= (l+r)//2
            i = mid_index // n 
            j = mid_index % n
            mid_term = matrix[i][j]

            if target == mid_term:
                return True
            elif target < mid_term:
                r = mid_index - 1
            else:
                l = mid_index + 1

        return False


       
