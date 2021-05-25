'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
# Run Row-wise binary search, then column wise binary search

#-----------------
# Time Complexity: 
#-----------------
# O(log(M) + log(N)) - Binary search on M elements first, then N elements
#------------------
# Space Complexity: 
#------------------
# O(1) - Only using constant space to store index values and lengths


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 24 ms   (99.94 %ile)
# Space            : 14.8 MB (29.91 %ile)

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
            r = row_length  - 1


            while l<=r:
                mid = (l+r)//2
                # print(f"l: {l}, r: {r}, mid: {mid}")
                
                if target == matrix[mid][0]:
                    return True
                else:
                    if target == matrix[mid][column_length-1]:
                        return True

                    
                    else:
                        if ((matrix[mid][0] < target) and \
                        target < (matrix[mid][column_length-1])):
                            #Binary Search on row here
                            left_column_search = 0 
                            right_column_search = column_length-1
                            while(left_column_search <= right_column_search):
                                mid_column_search = (left_column_search + \
                                    right_column_search)//2
                                
                                if target == matrix[mid][mid_column_search]:
                                    return True
                                elif target < matrix[mid][mid_column_search]:
                                    right_column_search = mid_column_search - 1
                                else:
                                    left_column_search = left_column_search + 1

                            return False


                    if (target < matrix[mid][0]):
                        r = mid - 1

                    if(target > matrix[mid][column_length-1]):
                        l = mid + 1

            return False

        
obj = Solution()
print(f"=={obj.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,50]], 11)}==")

print(f"=={obj.searchMatrix([[1,2,3],[4,5,6],[7,8,9]], 1)}==")

print(f"=={obj.searchMatrix( [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3)}==")

print(f"=={obj.searchMatrix( [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13)}==")