# Time Complexity : O(logmn) as it is binary search with m * n elements
# Space Complexity : O(1) as no extra space used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, took me a little time to understand 
# how to translate the matrix indices to find the pivot element


class BinSearch2dMat:

    # binary search implementation, with the variation of understanding 
    # how to translate the matrix indices to find the pivot element
    def binsearch2dmat(self, matrix, target: int) -> bool:
        mrows = len(matrix)
        if mrows == 0:
            return False
        ncols = len(matrix[0])
        left, right = 0, mrows * ncols - 1
        while left <= right:
            pivot_index = (left + right) // 2
            pivot_element = matrix[pivot_index // ncols][pivot_index % ncols]
            if target == pivot_element:
                return True
            else:
                if target < pivot_element:
                    right = pivot_index - 1
                else:
                    left = pivot_index + 1
        return False



matrix = [[1,3,5,7],
[10,11,16,20],
[23,30,34,60]]
target = 3

obj = BinSearch2dMat()
print(obj.binsearch2dmat(matrix, target))
