'''
Time Complexity - O(log(m*n))
Space Complexity - O(1)

Code is working on leetcode
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        # Method 1
        # top, bot = 0, rows #Get the top and bottom
        # while(top <= bot):
        #     row = top + (bot - top)//2
        #     if target > matrix[row][-1]: #ignore the top part if target greater than last element of middle row
        #         top = row + 1
        #     elif target < matrix[row][0]:#else ignore the bottom part
        #         bot = row - 1
        #     else: break from the loop if the target element lies in the mid row
        #         break
        # if not (top<=bot):
        #     return False

        # row = (top + bot)//2
        # l = 0
        # r = cols-1
        # while  l<=r: #Binary Search in 1D array after getting the row 
        #     mid = l + (r - l)//2
        #     if matrix[row][mid] == target:
        #         return True
        #     elif target > matrix[row][mid]:
        #         l=mid+1
        #     else:
        #         r=mid-1
        # if not l<=r:
        #     return False

        #Method 2
        low, high = 0,(rows * cols) - 1 #Consider high to be the product of number of rows and columns -1 we are considering the 2D matrix to be a single array
        while low <= high:
            mid = low + (high - low)//2
            if matrix[mid//cols][mid%cols] == target: #row number determined by dividing middle by columns in a row and the column numbers are found mid % columns
                return True
            elif target > matrix[mid//cols][mid%cols]:
                low = mid + 1
            else:
                high = mid -1 
        return False