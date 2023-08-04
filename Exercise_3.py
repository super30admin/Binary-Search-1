# ## Problem3
# Search in Infinite sorted array:

# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

# // Time Complexity : O()
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def searchMatrix(self, matrix, target):
        # rows and column length of matrix
        m = len(matrix)
        n = len(matrix[0])
        # defining two variables low
        low = 0
        # and high
        high = m * n - 1
        # binary search
        while (low <= high):
            # calculating mid
            mid = (low + high)//2
            # finding out row and col of mid
            r = mid//m
            c = mid % n
            # finding the mid element
            mid_ele = matrix[r][c]
            # if mid has target
            if target == mid_ele:
                # target in the array
                return True
            # if element in left part of the array
            elif target < mid_ele:
                # updating high - shortening search by 1/2
                high = mid - 1
            else:
                # updating low - shortening search by 1/2
                low = mid + 1
        return False


matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 3
sol = Solution()
print(sol.searchMatrix(matrix, target))
