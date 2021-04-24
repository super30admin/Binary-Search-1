// Time Complexity :O(log n) where n in the number elements in the matrix
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size() == 0) return false;
        int low = 0;
        int high = matrix.size()*matrix[0].size() -1;  //2D array is iterated as though its a 1D array to do binary search
        while(low<=high){
            int mid = low + (high-low)/2;
            int r = mid/matrix[0].size(); // find row index
            int c = mid%matrix[0].size(); // find col index
            cout<<r<<" "<<c<<" "<<mid<<endl;
            if(matrix[r][c] == target)   //regular binary search here after
                return true;
            else if(matrix[r][c] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
};