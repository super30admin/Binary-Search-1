// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size(),i=0,j=matrix[0].size()-1;
        while(i<n&&j>=0){
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]<target)
                i++;
            else
                j--;
        }
        return false;
    }
};