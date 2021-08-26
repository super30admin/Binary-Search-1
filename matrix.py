"""
Time Complexity-: o(logmn)
Space complexity- O(1)
For finding the target element in the matrix, we will image the matrix as a 1 dimensional array, and for finding the consecutive position
of a an element we will compute the row of that element as element/columns and we will compute the column of the element as element%columns.
Once we find the position, we can do binary search the usual way imaging it to be a 1 d array and finding target element in it
:return
"""

def matrixSearch(matrix, target):
    low=0
    high=rows*columns-1
    while(low<=high):
        mid=(low+high)//2
        r=mid//columns
        c=mid%columns
        if matrix[r][c]==target:
            return True
        elif matrix[r][c]>target:
            high=mid-1
        else:
            low=mid+1

    return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
target = 1
rows=len(matrix) ## 3
columns=len(matrix[0]) ##4
# print(rows)
# print(columns)
print(matrixSearch(matrix,target))

# matrix = []
# # taking 2x2 matrix from the user
# for i in range(2):
#    # taking row input from the user
#    row = list(map(int, input().split()))
#    # appending the 'row' to the 'matrix'
#    matrix.append(row)
# # printing the matrix
# print(matrix)
