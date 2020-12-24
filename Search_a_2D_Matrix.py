# Created by Aashish Adhikari at 4:27 PM 12/23/2020

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0:
            return False
        if len(matrix[0]) == 0:
            return False

        left = 0
        right = len(matrix)-1

        mid1 = len(matrix) // 2

        desired_row = None

        # Binary search among rows to find the desired row
        while left <= right:

            if matrix[mid1][0] > target:
                right = mid1 - 1

            elif matrix[mid1][len(matrix[0]) - 1]< target:
                left = mid1 + 1
            else:

                # Enters here only if the desired row is found
                desired_row = matrix[mid1]

                #Binary Search in this row now.

                left2 = 0
                right2 = len(desired_row)-1
                mid2 = len(desired_row) //2

                while left2 <= right2:

                    if desired_row[mid2] > target:
                        right2 = mid2 - 1
                    elif desired_row[mid2] < target:
                        left2 = mid2 + 1
                    else:
                        # Enters here only if the desired_row[mid] == target
                        return True

                    # Update midpoint
                    mid2 = left2 + (right2-left2)//2

                return False

            # Update midpoint
            mid1 = left + (right-left)//2

        return False


