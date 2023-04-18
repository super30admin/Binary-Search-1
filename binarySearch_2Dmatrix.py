class binarySearch:
     
    def searchMatrix(self, matrix, target):
        r = len(matrix)
        c = len(matrix[0])

        l, h = 0, (r * c) - 1
        
        while l <= h:
            mid = l + (h - l) // 2

            row = mid // c
            col = mid % c

            if (matrix[row][col] == target):
                return True

            elif(matrix[row][col] > target):
                h = mid - 1

            else:
                l = mid + 1

        return False


inputArr = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
input = binarySearch()
res = input.searchMatrix(inputArr, target)
print(res)