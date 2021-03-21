#complexity - O(m + log n)
# m - number of rows in matrix
# n - number of columns in matrix
def searchMatrix(matrix, target) -> bool:
    for array in matrix:
        if(array[len(array)-1] < target or array[0] > target):
            continue
        if(binarySearch(array, target)):
            return True
    return False

#BinarySearch
#complexity = O(log n)
def binarySearch(array, target) -> bool:
    left = 0
    right = len(array) - 1
    while(left <= right):
        mid = left + (right - left)//2
        if(array[mid] == target):
            return True
        elif (array[mid] < target):
            left = mid + 1
        else:
            right = mid - 1
    return False

#O(log(mn)) - solution
def searchMatrixAnotherSolution(matrix, target):
    m, n = len(matrix), len(matrix[0])
    low, high = 0, m*n-1
    while(low <= high):
        mid = low + (high-low)//2
        m1 = mid//n
        n1 = mid % n
        #print("mid ", str(mid), ", m " + str(m), ", n " + str(n))
        if(matrix[m1][n1] == target):
            return True
        elif(matrix[m1][n1] > target):
            low = mid + 1
        else:
            high = mid - 1
    return False

        

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 11
target1 = 13

print(searchMatrix(matrix, target))
print(searchMatrixAnotherSolution(matrix, target1))
