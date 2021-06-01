//Time Complexity: O(log(n)) + O(log(m)), binary search (rows) and binary search (columns)
//Space Complexity: O(1), no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
public:
    int findRow(vector<vector<int>>& matrix, int low, int high, int tar){
        int mid = low;
        while(low<high) {
            mid = low + (high-low)/2;
            if(tar == matrix[mid][0]){
                return mid;
            } else if(tar < matrix[mid][0]){
                high = mid-1;
            } else { //tar > matrix[mid][0]
                if(tar < matrix[mid+1][0]){
                    return mid;
                }
                low = mid+1;
            }
        }
        return low;
    }
    
    bool findColumn(vector<vector<int>>& matrix, int row, int low, int high, int tar){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(matrix[row][mid] == tar){
                return true;
            } else if(matrix[row][mid] < tar){
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rcount = matrix.size();
        int ccount = matrix[0].size();
        //cout << rcount << ", col:" << ccount << endl;
        int row = findRow(matrix, 0, rcount-1, target);
        bool result = findColumn(matrix, row, 0, ccount-1, target);
        return result;
    }
};
