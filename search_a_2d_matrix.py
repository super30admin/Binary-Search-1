'''
Appraoach:

TIme Complexity: O(logm * logn) where m is the number of rows and n is the number of columns.
Space Complexity: O(1)
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:



        m= len(matrix)
        n = len(matrix[0])

        rows_low=0
        rows_high= m-1


        # Finding the row using binary search.
        while(rows_low<=rows_high):

            # Find the mid of the row
            rows_mid = (rows_low+rows_high)//2


            if(matrix[rows_mid][0]<=target and matrix[rows_mid][n-1]>=target):

                col_low = 0
                col_high = n-1

                while(col_low<=col_high):
                    col_mid = (col_low+col_high)//2


                    if(matrix[rows_mid][col_mid]==target):
                        return True

                    elif(matrix[rows_mid][col_mid]>target):
                        col_high = col_mid-1

                    else:
                        col_low = col_mid+1
                return False

            elif(matrix[rows_mid][0]<target):
                rows_low=rows_mid+1
            else:
                rows_high=rows_mid-1


        return False



'''
Approach 2:
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        '''
        As problem explicitly mentions to solve the problem in O(log(m*n))
        I am applying the same methodology here as discussed in the class.

        Assuming there is a flattened array, and apply the binary search.

        In Assumption
        rows = mid/cols
        cols = mid%cols

        Time Complexity: O(log(m*n)) where m is the number of rows and n is the number of columns.
        Space Complexity: O(1)


        '''

        m= len(matrix)
        n= len(matrix[0])
        low= 0
        high = m*n-1

        while(low<=high):
            mid = (high+low)//2

            r = mid//n
            c = mid%n

            if matrix[r][c]==target:
                return True
            elif(matrix[r][c]>target):
                high = mid-1
            else:
                low = mid+1
        return False


