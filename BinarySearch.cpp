class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        vector<int> columnValues(m);
        for (int i = 0; i < m; i++) {
            columnValues[i] = matrix[i][0];
        }
        int rowValue = upper_bound(columnValues.begin(), columnValues.end(), target) - columnValues.begin() - 1;
        if (rowValue < 0) { return false; }
        return binary_search(matrix[rowValue].begin(), matrix[rowValue].end(), target);
    }
};