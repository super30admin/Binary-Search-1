// Time Complexity : O(log(sizeofmatrix))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) 
    {
        if(matrix.empty() || matrix[0].empty())
            return false;
        
        int rows = matrix.size();
        int columns = matrix[0].size();
        
        int start_index = 0;
        int end_index = ((rows*columns)-1);
        
        while(start_index <= end_index)
        {
            int mid_index = start_index + (end_index-start_index)/2;
            
            if(matrix[mid_index/columns][mid_index%columns] == target)
                return true;
        
            if(matrix[mid_index/columns][mid_index%columns] < target)
                start_index = mid_index+1;
            
            else
                end_index = mid_index-1;

        }
        return false;
    }
    
};