// Approach 1 - Apply binary search twice(once to find the row and again to find the column ion that row.)
// Time Complexity - O(log n). Sine we are using the Binary search to find the row to find the element and Binary search again to find the column at that row again.
// Space Comlexity - O(n). Since it depends on the number of elements in the 2D array? Is my answer correct?
// Problems faced - No!
// It runs on leetcode!

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        
        int rLow = 0, rHigh = rows - 1, rMid;
        
        while(rLow < rHigh){
            rMid = rLow + (rHigh - rLow)/2;
            if(matrix[rMid][0] > target)
                rHigh = rMid - 1;
            else if(matrix[rMid][cols - 1] < target)
                rLow = rMid + 1;
            else{
                rLow = rMid;
                break;
            }
        }
        
        int cLow = 0, cHigh = cols -1, cMid;
        
        while(cLow <= cHigh){
            cMid = cLow + (cHigh - cLow)/2;
            if(matrix[rLow][cMid] > target)
                cHigh = cMid - 1;
            else if(matrix[rLow][cMid] < target)
                cLow = cMid + 1;
            else 
                return true;
        }
        
        return false;
    }
};
