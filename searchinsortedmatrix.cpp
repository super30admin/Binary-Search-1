#include <iostream>
#include <vector>

// Time Complexity : O(log mn) Binary Search where m is the number of rows and n is the number of columns
// Space Complexity : O(1) Constant Space
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
using namespace std;
class Solution {
public: 
    bool searchMatrix(vector<vector<int>>& matrix, int target) 
    {
        if(matrix.size() == 0)
        {
            return false;
        }
        
        int rowCount = matrix.size();
        int columnCount = matrix[0].size();
        
        int low = 0;
        int high = (rowCount * columnCount) - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2; //To avoid int overflow
            int row = mid / columnCount; // Get number of row of the index
            int column = mid % columnCount; // Get number of column of the index
            if(matrix[row][column] == target)
            {
                return true;
            }
            else if(target < matrix[row][column])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return false;
    }
};

int main()
{
    Solution sln;
    vector<vector<int>> temp = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    cout << sln.searchMatrix(temp,13);
}