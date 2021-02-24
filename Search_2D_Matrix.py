#Time complexity: O(n*log m)
#space complexity: O(1) 
#problem run on leetcode: yes
class solution(object):
    def searchMatrix(self, matrix, target):
        n = len(matrix) #number of rows
        m = len(matrix[0]) #number of columns
        
        low = 0
        high = n*m-1 #total number of elements -1
        
        while (low <= high):
            mid = low + (high - low)//2 #1D array index
            #convert 1D index to 2D matrix index
            i = int(mid/m)
            j = int(mid%m)
            
            #comparing target to the element at index i,j
            if (matrix[i][j] == target):
                return True
            elif (matrix[i][j] < target):
                low = mid + 1
            else:
                high = mid - 1
        return False
