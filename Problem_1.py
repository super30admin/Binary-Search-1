# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : N/A
# Leetcode Link: https://leetcode.com/problems/search-a-2d-matrix/

# // Your code here along with comments explaining your approach
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

    '''
    Initial sub-optimal approach: 
    - Linear Search along first index
    - The first element where element > target, binary search on the previous row 
    - TC: O(M logN)

    Improvement: 
    - Convert M X N matrix into a "logical" M*N array
    - Binary search over indices 0 to M*N
    - for each element at idx in [0, M*N), their indices are: row= idx//N, col = idx%N
    '''
    m, n = len(matrix), len(matrix[0])
    l, r = 0, m*n-1
    while l <= r:
        mid = (l + r)//2
        mid_ele = matrix[mid//n][mid%n]
        print(mid_ele)
        if mid_ele == target: 
            return True
        if mid_ele < target:
            l = mid+1
        else:
            r = mid-1 
    return False
        