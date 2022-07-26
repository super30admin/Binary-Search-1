# Time Complexity : O(log(mn)), where m and n are matrix dimensions
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


def search_matrix(matrix, target) -> bool:

    m=len(matrix)
    # if matrix is empty
    if m==0:
        return False
    n=len(matrix[0])
    # running binary search on sorted matrix 
    left,right=0,m*n-1

    while left<=right:
        mid_idx=(left+right)//2
        # visualizing a sorted matrix as a sorted array where row and col are as follows
        mid=matrix[mid_idx//n][mid_idx%n]
        if target==mid:
            return True
        else:
            if target < mid:
                right=mid_idx-1
            else:
                left=mid_idx+1
    return False