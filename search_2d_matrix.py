'''
Perform binary search by taking low as first row and high as last row initially, and compute mid row, if element present in the range of selected mid row,
perform another binary search on row, else compute new mid by moving low if element present after mid row or move high if element present before mid row.
'''

#Time Complexity: O(log(M)+log(N)) or O(log(MN))
#Space Complexity: O(1)

#Passes all testcases in leetcode

class Solution:
    
    def firstBin(self,cols,matrix,target):
        #Find the row which contains the element and call second binary function
        low = 0
        high = len(matrix)-1
        while(low <= high):
            mid = low + (high-low)//2
            #print(matrix[mid][0])
            #Target within the range of given row
            if target >= matrix[mid][0] and target <= matrix[mid][cols]:
                res = self.secondBin(mid,matrix,target,cols)
                return res
        
            elif target < matrix[mid][0]:
                print("modified high")
                high = mid - 1
                
            else: 
                low = mid + 1
                
        return False
    
    def secondBin(self,mid,matrix,target,cols):
        #print("mid", mid)
        left = 0
        right = cols

        while(left<=right):
            fmid = left + (right-left)//2
            if target == matrix[mid][fmid]:
                return True
            if target > matrix[mid][fmid]:
                left = fmid+1
            else:
                right = fmid-1
        return False
        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        
        cols = len(matrix[0])-1

        res = self.firstBin(cols,matrix,target)
        
        if res == False:
            #print("returning res false")
            return False
        else:
            return True
