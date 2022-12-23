# Time Complexity :
# O(log NM)

# Space Complexity :
# O(NM) - we do not store any values

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low = 0
        high = len(matrix) - 1
        middle = int (low + (high - low)/2)
        correct_row = -1
        #print (low,middle,high)

        #Find the correct row
        while low <= high :
            #print (matrix[low:high+1])
            #print (low,middle,high)
            if target > matrix[high][0]:
                correct_row = high
                break
            if matrix[middle-1][0] <= target and target < matrix[middle][0]:
                correct_row = middle -1
                break
            elif matrix[middle][0] < target and target < matrix[middle+1][0]:
                correct_row = middle
                break
            #If value found, return True
            elif matrix[middle][0]== target:
                return True
            #If value smaller than middle then look in first half
            elif target < matrix[middle][0]:
                high = middle -1
                middle = int (low + (high - low)/2)
            #If value larger than middle then look in second half
            else :
                low = middle + 1
                middle = int (low + (high - low)/2)

        low = 0
        high = len(matrix[0]) -1
        middle = int (low + (high - low)/2)
        #Find the element in the correct row
        while low <= high :
            if target == matrix[correct_row][middle] :
                return True
            elif  target < matrix[correct_row][middle]:
                high = middle -1
                middle = low + int((high - low)/2)
            else :
                low = middle +1
                middle = low + int((high - low)/2)
        return False
