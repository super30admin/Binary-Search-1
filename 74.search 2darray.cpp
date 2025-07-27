class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if(m == 0)return false;    // if empty
        int n = matrix[0].size();
        int l=0;
        int h =(m*n)-1;
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            int r= mid/n;            //visualize 1d array and find out row and column index
             int c= mid%n;
            if(matrix[r][c]==target)  // apply binary search logic to elimate one half
             return true;
             else if(matrix[r][c]<target)
               l = mid+1;
            else
            h = mid-1;
        } 
        return false;
    }
};