'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
# Treat 2D array as unrolled 1D array

#-----------------
# Time Complexity: 
#-----------------
# O(log(M*N)) - Binary search on M*N elements
#------------------
# Space Complexity: 
#------------------
# O(1) - Only using constant space to store index values and lengths


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 44 ms   (60.49 %ile)
# Space            : 14.4 MB (99.38 %ile)

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_length = len(matrix)
        # print(f"matrix: {matrix}, target: {target}")

        if row_length == 0:
            return False

        else:

            column_length = len(matrix[0])
                        
            l = 0
            r = (row_length * column_length) - 1

            while l<=r:
                mid = (l+r)//2
                # print(f"l: {l}, r: {r}, mid: {mid}")

                column_index = mid // column_length
                row_index = mid % column_length

                # print(f"row_index: {row_index}, column_index: {column_index}")
                
                if target == matrix[column_index][row_index]:
                    return True
                else:
                    if target < matrix[column_index][row_index]:
                        r = mid-1

                    else:
                        l = mid+1

            return False

        
obj = Solution()
print(f"=={obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,50]], 11)}==")

print(f"=={obj.searchMatrix([[1,2,3],[4,5,6],[7,8,9]], 1)}==")

print(f"=={obj.searchMatrix( [[1,3,5,7],[10,11,16,20],[23,30,34,60]],3)}==")