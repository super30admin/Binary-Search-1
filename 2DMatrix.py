class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)  # Number of Rows
        n = len(matrix[0])  # Number of columns

        # print(m)
        # print(n)

        low = 0
        high = n * m - 1;

        while (low <= high):
            mid_index = low + (high - low) // 2
            mid_element = matrix[mid_index // n][mid_index % n]
            if target == mid_element:
                return True
            else:
                if target > mid_element:
                    low = mid_index + 1
                else:
                    high = mid_index - 1
        return False


    """
    Time Complexity : O(Log mn) since Binary Search
    Space Complexity: O(1) since we are not rewriting the array into temp array
    """