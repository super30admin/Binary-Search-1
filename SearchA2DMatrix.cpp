// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I assumed the 2D array as flattened array.


#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    bool searchMatrix(vector< vector<int> >& matrix, int target) {
        int noRows = matrix.size();
        int noCol= matrix[0].size();
        
        
        int low=0;
        int high=noRows*noCol-1;
        
        
        while(low<=high)
        {
            int middleElementIndex=low+(high-low)/2;

            int r=middleElementIndex/noCol;
            int c=middleElementIndex%noCol;
            
            if(matrix[r][c]==target)
            {
                return true;
            }
            else if(target < matrix[r][c])
            {
                high=middleElementIndex-1;
            }
            else
            {
                low=middleElementIndex+1;
            }
        }
        return false;
    }
};