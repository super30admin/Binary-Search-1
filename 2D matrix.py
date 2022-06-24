// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix);
        n = len(matrix[0]);
        low = 0;
        multi = m*n;
        high = multi-1;
        
        while low <= high :
            
            mid =  ((low + high)//2);
            row = (mid//n);
            column = mid % n;
            # print(f'{low},{mid},{high},{row},{column},{matrix[row][column]}');
            if matrix[row][column] == target:
                return True;
            elif target < matrix[row][column]:
                high = mid-1;
            else:
                low = mid+1;
        return False;
                