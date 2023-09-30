// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Technique: Binary Search whole matrix like 1-D array
// By given properties, we see that whole row is started and the next row starts after the last element which means both rows if appended in order will form sorted array of 2*n size.
// Hence, whole matrix can be seen as a single sorted array of size m*n.
// We can do normal BS on this.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rc = matrix.size();
        int cc = matrix[0].size();
        int st = 0, end = rc*cc-1;

        while(st <= end) {
            int mid = st+(end-st)/2;
            int currElem = getElem(matrix, mid);
            if(currElem == target) {
                return true;
            }
            else if(currElem < target) {
                st = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return false;
    }

    int getElem(vector<vector<int>>& matrix, int idx) {
        int cc = matrix[0].size();
        int rowNum = idx/cc;
        int colNum = idx%cc;
        return matrix[rowNum][colNum];
    }
};

int main() {
    vector<vector<int>> matrix{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 3;
    Solution S;
    cout<<S.searchMatrix(matrix, target)<<endl;
}