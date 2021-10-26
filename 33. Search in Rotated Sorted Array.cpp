//Time Complexity = O(log n)
//Space Complexity = O(1)

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size()==0)
            return false;
        int low=0,high,mid;
        int row = matrix.size();
        int col = matrix[0].size();
        high = (row*col)-1;
        int r,c;
        while(low<=high)
        {
            mid = low + (high - low)/2;
            r = mid/col;
            c = mid%col;
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
};
