"""
All elements from 2D are flattened into a 1D sorted array, since each row is also sorted.
Each index corresponds to the div and mod with the no of cols. 
Now we perform our regular binary search to find the element. 
"""
"""
Time Complexity: O(log(m * n)) - (Binary serach on flatted 1D array)
Space Complexity: O(1) – No extra space used
"""


class TwoDMatrix:

    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:

        rows = len(matrix)
        cols = len(matrix[0])
        left, right = 0, rows * cols - 1

        while left <= right:

            mid = (left + right) // 2

            row = mid // cols
            col = mid % cols

            mid_val = matrix[row][col]

            if mid_val == target:
                return True
                
            elif mid_val > target:
                right = mid - 1

            else:
                left = mid + 1

        return False

if __name__=="__main__":
    twoD = TwoDMatrix()
    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    print(twoD.searchMatrix(matrix,3))
    print(twoD.searchMatrix(matrix,100))

