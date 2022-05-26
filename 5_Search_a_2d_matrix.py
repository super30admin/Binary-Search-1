// Time Complexity :O(log(m)+log(n)) = O(log(mn))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i accidentally have a typo so my code ran incorrect, later i rectified that.
// Your code here along with comments explaining your approach
// before solving this in this approach i tried linear search which gave me O(mn) complexity which is not optimal.
// by implementing binary search on rows we  can figure out which row our data is present by taking the advantage of sortedness of the array.
// after getting into particular row we do binary search on it.
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        high = len(matrix)-1
        low = 0
        while low <= high:
            mid = (high+low)//2
            row = matrix[mid]
            if target<row[0]:high=mid-1
            elif target>row[-1]:low=mid+1
            else:
                l,h=0,len(row)-1
                while l<=h:
                    mid=(l+h)//2
                    if row[mid] == target: return True
                    elif target>row[mid]:l=mid+1
                    else: h= mid-1
                return False        
        return False