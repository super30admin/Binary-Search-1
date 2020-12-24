# Time Complexity : binary search is logn, here it will be O(L*B) L-length B- breadth 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Should we look for a modular code during interview? Like having a separate binary search function and init for global vars
# Your code here along with comments explaining your approach
class twoDSearch:
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        # base condition- if no elements return False
        if m == 0:
            return False
        n = len(matrix[0])       
        # we will use binary search coz the matrix is sorted. binary search: match target to pivot element(changes based on requirement-here we will be considering mid element) each time- if not matches focus on smaller to mid(target<mid) or higher to mid elements(target > mid)- compute mid element of each scope of array considered or during each iteration.
        # We will be converting matrix to a virtual array starting from first element of first row and last element is last element of last row
        l, r = 0, m * n - 1
        while l <= r:
                # capture pivot index each iter
                mid = l + (r -l) // 2
                # we can access mid element from the index of the virtual array by:
                midElement = matrix[mid // n][mid % n]
                if target == midElement:
                    return True
                else:
                    if target < midElement:
                        r = mid - 1
                    else:
                        l = mid + 1
        return False

# Driver code
obj = twoDSearch()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
target = 13
print(obj.searchMatrix(matrix, target))