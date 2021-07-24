# Time Complexity : O(log(mn))
# Space Complexity : O(1), we only use 5 extra variables. So it's constant time irrespective of the input size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No.

def searchMatrix(matrix: list[list[int]], target: int) -> bool:
    m = len(matrix)
    n = len(matrix[0])
    l,h = 0, m*n-1
    while l<=h:
        mid = l + (h-l)//2   # Prevent overflows
        r = mid//n;
        c = mid%n;
        if matrix[r][c] == target:
            return True
        elif matrix[r][c] > target:
            h = mid-1
        else:
            l = mid+1