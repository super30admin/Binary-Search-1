# Time Complexity : O(log r * log c) where r = number of rows and c = number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


/*We run binary search through the rows first (log r), then we run binary serach within that column (log c) to find the target*/
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int r = matrix.size();
        int c = matrix[0].size();
        if(r==0) return false;

        int r1 = 0, r2=r-1, mid;
        while(r1 < r2)
        {
            mid = r1 + (r2-r1)/2;
            if(matrix[mid][c-1] < target)
                r1 = mid+1;
            else if(matrix[mid][0] > target)
                r2 = mid-1;
            else
            {
                r1=mid;
                break;
            }
        }

        int c1 = 0, c2 = c-1, mid2;
        while(c1 < c2)
        {
            mid2 = c1 + (c2-c1)/2;
            if(matrix[r1][mid2] < target)
                c1 = mid2+1;
            else if(matrix[r1][mid2] > target)
                c2 = mid2-1;
            else
                return true;
        }
        return false;
    }
};