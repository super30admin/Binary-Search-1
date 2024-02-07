// 74. Search a 2D Matrix
// Time Complexity : log(m*n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only
// assuming the 2d matrix into a 1d matrix and using binary search to search for the element.
bool searchMatrix(vector<vector<int>>& matrix, int target) {
    int m = matrix.size(), n = matrix[0].size();
    int low = 0, high = m*n - 1, mid; //  
    while(low <= high)
    {
        mid =  low + (high - low)  / 2;
        if(matrix[mid/n][mid%n] == target)
            return true;
        if(matrix[mid/n][mid%n] >= target &&  matrix[low / n][low % n] <= target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return false;