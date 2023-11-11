class Solution {
public:
/*
0   2
1
0
*/
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int low=0,high=matrix.size()*matrix[0].size();
        while(low<=high) {
            int mid=low+((high-low)/2);
            int r=mid/matrix[0].size();
            int c=mid%matrix[0].size();
            if(r<matrix.size() && c<matrix[0].size()) {
                if(matrix[r][c]==target) return true;
                else if(matrix[r][c]<target) low=mid+1;
                else high=mid-1;
            } else break;
        }
        return false;
    }
};