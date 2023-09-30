// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Technique: Simple linear search
// Traverse row by row all elements till we get the target

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        for(vector<int> row: matrix) {
            for(int elem: row) {
                if(elem == target) {
                    return true;
                }
            }
        }
        return false;
    }
};

int main() {
    vector<vector<int>> matrix{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 3;
    Solution S;
    cout<<S.searchMatrix(matrix, target)<<endl;
}