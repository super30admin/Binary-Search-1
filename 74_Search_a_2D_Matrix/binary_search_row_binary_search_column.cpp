// Time Complexity : O(log(m) + log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Technique: Binary search to get appropriate row then BS to get appropriate row in that column
// We use the property that row starts are sorted.
// Say rows are 0 to m-1. We check middle row, if this rows first element is greater than target then target is not in this row and check [0..mid-1].
// Rows first elements less than the target then see if the target exists in this row (by doing binary search in the row)
// else search in [mid+1..m]. If not found return false.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rc = matrix.size();
        int cc = matrix[0].size();

        int rs = 0, re = rc-1;
        while(rs <= re) {
            int mid = rs + (re-rs)/2;
            vector<int> row = matrix[mid];
            if(row[0] <= target && row[row.size()-1] >= target) {
                return binarySearchRow(row, target);
            }
            if(row[0] < target) {
                rs = mid+1;
            }
            else {
                re = mid-1;
            }
        }
        return false;
    }

    bool binarySearchRow(vector<int> row, int target) {
        int left = 0, right = row.size()-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(row[mid] == target) {
                return true;
            }
            if(row[mid] < target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return false;
    }
};

int main() {
    vector<vector<int>> matrix{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 13;
    Solution S;
    cout<<S.searchMatrix(matrix, target)<<endl;
}