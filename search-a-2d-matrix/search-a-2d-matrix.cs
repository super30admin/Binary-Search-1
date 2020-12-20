public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.Length ==0) return false;
        
        int rows = matrix.Length;
        int cols = matrix[0].Length;
        
        int left =0; int right = rows * cols -1;
        int id,element;
        
        while(left<=right)
        {
            id = (left+right)/2;
            element = matrix[id/cols][id % cols];
            if(target ==element)
            {
                return true;
            }
            else if (target < element)
            {
                right = id -1;
            }
            else
            {
                left = id+1;
            }
        }
        return false;
        
    }
}
