// Time Complexity : Log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
/* Treat 2D array as a flat array and apply binary search on that.
 * 
 * Start low with 0 and high with size() - 1;
 * Compute mid, to get mid element in 2D matrix use following formula :- matrix[mid / cols][mid % cols].
 */
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        if (matrix.size() == 0)
            return false;
        
        int n = matrix.size();
        int m = matrix[0].size();
        
        int low = 0;
        int high = n * m - 1;
        int mid;
        int r, c;
        
        while (low <= high)
        {
            mid = low + ((high - low)/2);
            
            r = mid / m;
            c = mid % m;
            
            if (matrix[r][c] == target)
            {
                return true;
            }
            else if (matrix[r][c] > target)
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