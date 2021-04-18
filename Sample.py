
'''
// Time Complexity : I have used multiple approaches below, most efficient is O(N)
// Space Complexity : I have used multiple approaches below, most efficient is O(1), which is in- place comparison without extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, it took me some time to get to the optimal solution, the brute force was straight forward to think and code

//Your code here along with comments explaining your approach
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        '''
        Approach 1 - Brute force method, inefficient, traversing the matrix in two nested for loop way to check
        Time complexity - O(N^2)
        Space complexity - In place search O(1)




        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if target == matrix[i][j]:
                    return True

        # if the element is is not found , the code flow reaches here
        return False




        Approach 2 - Flatten the matrix as an array and search in an array, again non-efficient since O(N^2) again, to
        1. flatten the list and next search linearly or in a binary search way , O(log(N)).
        but the overall time complexity will still be O(N^2)


        res = []
        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                res.append(matrix[i][j])

        lo = 0
        hi = len(res) -1
        while(lo <= hi):
            mid = (lo) + (hi-lo) //2
            if res[mid] == target:
                return True
            elif res[mid] < target:
                lo  = mid + 1
            else:
                hi = mid - 1

        return False

        '''

        # Approach 3 - Trick of moving from the diaginally right corner and increment row if target is greater else decrement the col
        # if target is smaller, we use the property of the matrix  (not my original idea)
            # Time complexity - O(N)
            #Space complexity - O(N^2)


        # top rightmost element
        row = 0
        col  = len(matrix[0]) - 1
        # base cases for iteration
        while(row <= len(matrix)-1 and col >= 0):
            if target == matrix[row][col]:
                return True
            # move downwards, as the elements are increasing in that order
            elif(target > matrix[row][col]):
                row += 1
            # move leftwords as the elements are decreasing in that direction
            else:
                col -= 1
        # no element is found, return False
        return False
























