# // Time Complexity : O(Log MxN)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : While traversing the first "mid Row" I ended up on a bug. Hence I added a new conditional in it


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        
        #Do Binary Search over the 1st Elements of the ROWS to get the rowMidIdx - O(Log M)
        lo, hi = 0, ROWS - 1
        rowMidIdx = 0

        while lo <= hi:
            mid = (lo+hi)//2
        
            if  target in [matrix[mid][0], matrix[mid][-1]]:
                return True
            elif target > matrix[mid][0]:
                if target < matrix[mid][-1]:
                    rowMidIdx = mid
                    break
                lo = mid + 1
            elif target < matrix[mid][0]:
                hi = mid - 1
        
        #With the above rowMidIdx row perform binary search over the COLS' Elements - O(Log N)
        print(rowMidIdx)
        midList = matrix[rowMidIdx]
        lo, hi = 0, len(midList) - 1

        while lo <= hi:
            midIdx = (lo+hi)//2
            if midList[midIdx] == target:
                return True
            elif midList[midIdx] > target:
                hi = midIdx - 1
            else:
                lo = midIdx + 1
        
        return False
